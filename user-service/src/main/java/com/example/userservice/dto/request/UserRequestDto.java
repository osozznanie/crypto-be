package com.example.userservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank
    private String walletAddress;
    @NotNull
    private BigDecimal walletBalance;
}
