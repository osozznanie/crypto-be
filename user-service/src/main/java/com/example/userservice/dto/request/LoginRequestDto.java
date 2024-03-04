package com.example.userservice.dto.request;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
    private String totp;
}
