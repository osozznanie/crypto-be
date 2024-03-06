package com.example.transactionservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PixelTransactionWithoutCompanyIdRequestDto {
    @NotNull
    private String userEmail;
    @NotBlank
    private String companyName;
    private String logoLink;
    @NotBlank
    private String websiteLink;
    private String description;
    @NotBlank
    private String countryTag;
    @NotBlank
    private String currency;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Long pixelNumber;
    @NotBlank
    private String transactionId;
}
