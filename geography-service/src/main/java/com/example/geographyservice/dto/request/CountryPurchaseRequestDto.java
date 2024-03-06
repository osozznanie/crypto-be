package com.example.geographyservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CountryPurchaseRequestDto {
    @NotNull
    private String continentId;
    @NotNull
    private String companyId;
    @NotNull
    private String userEmail;
    @NotNull
    private Long pixelNumber;
}
