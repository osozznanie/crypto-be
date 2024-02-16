package com.example.userservice.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String walletAddress;
    private BigDecimal walletBalance;
}
