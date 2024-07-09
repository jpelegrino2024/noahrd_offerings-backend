package com.julioluis.offeringsbackend.repositories;

import com.julioluis.offeringsbackend.entities.SpentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpentTypeRepository extends JpaRepository<SpentType,Long> {
}
