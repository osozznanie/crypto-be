package com.example.userservice.dto.response;

import com.example.userservice.enums.RegisterStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDTO {
    private RegisterStatus status;
    private String message;
    private UserDto registeredUser;
    private String totpSecretKey;
    private byte[] qrCodeUrl;
}
