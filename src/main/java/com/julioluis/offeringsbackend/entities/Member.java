package com.julioluis.offeringsbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "rol_id")
    private Rol rol;

}
