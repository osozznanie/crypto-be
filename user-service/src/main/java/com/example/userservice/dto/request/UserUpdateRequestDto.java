package com.example.userservice.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private String email;
    private Long pixelNumber;
}
