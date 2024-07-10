package com.julioluis.offeringsbackend.services.impl;

import com.julioluis.offeringsbackend.entities.Member;
import com.julioluis.offeringsbackend.repositories.MemberRepository;
import com.julioluis.offeringsbackend.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member findByEmail(String email) {
        return memberRepository.getByEmail(email).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.getByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }
}
