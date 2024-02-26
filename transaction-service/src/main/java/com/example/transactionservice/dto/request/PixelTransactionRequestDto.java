package com.example.transactionservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PixelTransactionRequestDto {
    @NotBlank
    private String senderCompanyId;
    @NotBlank
    private String receiverCompanyId;
    @NotBlank
    private String countryId;
    @NotBlank
    private String currency;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Long pixelNumber;
    @NotBlank
    private String transactionType;
    @NotBlank
    private String transactionId;
}