//package com.julioluis.offeringsbackend.config;
//
//import com.julioluis.offeringsbackend.entities.Member;
//import com.julioluis.offeringsbackend.entities.Rol;
//import com.julioluis.offeringsbackend.services.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//
//@Component
//@Transactional
//public class MemberAuthProvider implements AuthenticationProvider {
//
//    @Autowired
//    private MemberService memberService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        Member member = memberService.findByEmail(username);
//        if(Objects.nonNull(member)) {
//            if (passwordEncoder.matches(password,member.getPassword())) {
//                return new UsernamePasswordAuthenticationToken(username,password,getGrantedAuthority(member.getRol()));
//            }else {
//                throw new BadCredentialsException("Invalid password");
//            }
//        }
//        throw new BadCredentialsException("No user register with that credential");
//    }
//
//    private List<GrantedAuthority> getGrantedAuthority(Rol rol) {
//        final List<GrantedAuthority> authorities = new ArrayList<>();
//        rol.getAuthorities().forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName())));
//        return authorities;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}
