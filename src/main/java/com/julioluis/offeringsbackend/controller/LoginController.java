package com.julioluis.offeringsbackend.controller;

import com.julioluis.offeringsbackend.entities.Member;
import com.julioluis.offeringsbackend.models.AuthenticationResponse;
import com.julioluis.offeringsbackend.services.AuthenticationService;
import com.julioluis.offeringsbackend.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Member request) {
        return ResponseEntity.status(201).body(authenticationService.register(request));
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Member request) {
        return ResponseEntity.ok().body(authenticationService.authenticate(request));
    }
}
