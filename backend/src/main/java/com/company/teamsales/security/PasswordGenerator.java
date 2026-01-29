package com.company.teamsales.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("ADMIN  : " + encoder.encode("admin123"));
        System.out.println("TL     : " + encoder.encode("tl123"));
        System.out.println("AGENT  : " + encoder.encode("agent123"));
    }
}
