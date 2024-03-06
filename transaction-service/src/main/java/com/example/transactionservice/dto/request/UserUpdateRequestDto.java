package com.example.transactionservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdateRequestDto {
    private String email;
    private Long pixelNumber;
}
