package com.example.marketplaceservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class MarketListingRequestDto {
    @NotNull
    private String companyId;
    @NotNull
    private String countryId;
    @NotBlank
    private String currency;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Long pixelNumber;
}
