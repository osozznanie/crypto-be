package com.example.userservice.controller;

import com.example.userservice.dto.request.LoginRequestDto;
import com.example.userservice.dto.request.UserRequestDto;
import com.example.userservice.dto.response.LoginResponseDTO;
import com.example.userservice.dto.response.RegisterResponseDTO;
import com.example.userservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> createAuthToken(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            LoginResponseDTO response = authService.createAuthToken(loginRequestDto);
            switch (response.getStatus()) {
                case SUCCESS -> {
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                case INVALID_CREDENTIALS -> {
                    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
                }
                case TOTP_REQUIRED -> {
                    return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
                }
                default -> {
                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> registerUser(@RequestBody UserRequestDto userDto) {
        try {
            RegisterResponseDTO response = authService.createNewUser(userDto);
            switch (response.getStatus()) {
                case SUCCESS -> {
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                }
                case USERNAME_TAKEN, EMAIL_TAKEN -> {
                    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
                }
                default -> {
                    System.out.println(response.getMessage());
                    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
