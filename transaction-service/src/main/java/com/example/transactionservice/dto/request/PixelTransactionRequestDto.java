package com.example.transactionservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PixelTransactionRequestDto {
    @NotBlank
    private String senderCompanyId = "TestCompany-ID";
    @NotBlank
    private String receiverCompanyId;
    @NotBlank
    private String countryTag;
    @NotBlank
    private String currency = "USD";
    @NotNull
    private BigDecimal price = new BigDecimal(20);
    @NotNull
    private Long pixelNumber;
    private String transactionType;
    @NotBlank
    private String transactionId = "transaction-ID";
}
