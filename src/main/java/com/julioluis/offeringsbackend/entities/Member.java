package com.julioluis.offeringsbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Member implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return extractAuthorities(rol);
    }

    private List<GrantedAuthority> extractAuthorities(Rol rol) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        rol.getAuthorities().forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth.getAuthorityName())));
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
