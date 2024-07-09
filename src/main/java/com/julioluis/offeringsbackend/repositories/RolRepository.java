package com.julioluis.offeringsbackend.repositories;

import com.julioluis.offeringsbackend.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
}
