package com.example.userservice.dto.response;

import com.example.userservice.enums.ERole;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String email;
    private ERole role;
}
