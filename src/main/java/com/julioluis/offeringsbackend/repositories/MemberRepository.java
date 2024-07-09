package com.julioluis.offeringsbackend.repositories;

import com.julioluis.offeringsbackend.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> getByEmail(String email);
}
