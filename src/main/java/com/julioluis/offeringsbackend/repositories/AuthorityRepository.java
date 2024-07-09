package com.julioluis.offeringsbackend.repositories;

import com.julioluis.offeringsbackend.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
}
