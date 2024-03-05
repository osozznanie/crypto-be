package com.example.transactionservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryPurchaseRequestDto {
    @NotNull
    private String continentId;
    @NotNull
    private String companyId;
    @NotNull
    private Long pixelNumber;
}
