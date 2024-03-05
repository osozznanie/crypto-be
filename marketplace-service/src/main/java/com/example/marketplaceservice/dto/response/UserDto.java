package com.example.marketplaceservice.dto.response;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String email;
    private ERole role;
}
