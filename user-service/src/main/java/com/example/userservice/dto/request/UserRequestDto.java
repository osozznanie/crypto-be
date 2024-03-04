package com.example.userservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
}
