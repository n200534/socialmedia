package com.example.socialmedia.controller;

import com.example.socialmedia.dto.LoginRequest;
import com.example.socialmedia.dto.LoginResponse;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.security.JwtUtil;
import com.example.socialmedia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService , JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {

        User user = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}
