package com.company.teamsales.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordRunner {

    @Bean
    CommandLineRunner generatePasswords(BCryptPasswordEncoder encoder) {
        return args -> {
            System.out.println("ADMIN  : " + encoder.encode("admin123"));
            System.out.println("TL     : " + encoder.encode("tl123"));
            System.out.println("AGENT  : " + encoder.encode("agent123"));
        };
    }
}
