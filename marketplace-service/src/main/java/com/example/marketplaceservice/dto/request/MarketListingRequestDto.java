package com.example.marketplaceservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class MarketListingRequestDto {
    @NotNull
    private String userEmail;
    @NotNull
    private String countryId;
    @NotBlank
    private String currency;
    @NotNull
    private BigDecimal price;
    @NotNull
    private List<String> pixelIds;
}
