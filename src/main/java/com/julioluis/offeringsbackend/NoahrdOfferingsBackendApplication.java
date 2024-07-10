package com.julioluis.offeringsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true)
public class NoahrdOfferingsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoahrdOfferingsBackendApplication.class, args);
    }

}
