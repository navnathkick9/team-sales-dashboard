package com.company.teamsales.controller;

import com.company.teamsales.dto.request.LoginRequest;
import com.company.teamsales.dto.response.LoginResponse;
import com.company.teamsales.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
