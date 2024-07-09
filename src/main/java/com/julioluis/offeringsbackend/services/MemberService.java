package com.julioluis.offeringsbackend.services;

import com.julioluis.offeringsbackend.entities.Member;

public interface MemberService {
    Member findByEmail(String email);

}
