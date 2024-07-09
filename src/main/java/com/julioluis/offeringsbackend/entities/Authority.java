package com.julioluis.offeringsbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorityName;
    @ManyToMany(mappedBy = "authorities")
    private Set<Rol> roles;
}
