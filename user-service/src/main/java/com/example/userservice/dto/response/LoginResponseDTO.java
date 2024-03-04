package com.example.userservice.dto.response;

import com.example.userservice.enums.LoginStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {
    private LoginStatus status;
    private String message;
    private UserDto userDto;
    private String token;
}