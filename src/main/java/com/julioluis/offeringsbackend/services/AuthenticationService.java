package com.julioluis.offeringsbackend.services;

import com.julioluis.offeringsbackend.entities.Member;
import com.julioluis.offeringsbackend.entities.Rol;
import com.julioluis.offeringsbackend.jwt.JwtService;
import com.julioluis.offeringsbackend.models.AuthenticationResponse;
import com.julioluis.offeringsbackend.repositories.MemberRepository;
import com.julioluis.offeringsbackend.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;

@Service
public class AuthenticationService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RolRepository rolRepository;

    public AuthenticationResponse register(Member request) {
        Member member = new Member();

        member.setFirstName(request.getFirstName());
        member.setLastName(request.getLastName());
        member.setEmail(request.getEmail());
        member.setPassword(passwordEncoder.encode(request.getPassword()));
        Rol rol = rolRepository.findById(request.getRol().getId()).orElseThrow();
        member.setRol(rol);

        Member saveMember = memberRepository.save(member);

        String token = jwtService.createToken(saveMember);

        return  new AuthenticationResponse(token);

    }

    public AuthenticationResponse authenticate(Member request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                ) );

        Member member = memberRepository.getByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.createToken(member);

        return new AuthenticationResponse(token);
    }


}
