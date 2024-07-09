package com.julioluis.offeringsbackend.repositories;

import com.julioluis.offeringsbackend.entities.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpentRepository extends JpaRepository<Spent,Long> {
}
