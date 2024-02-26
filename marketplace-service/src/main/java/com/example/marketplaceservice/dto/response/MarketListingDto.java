package com.example.marketplaceservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MarketListingDto {
    private String id;
    private String companyId;
    private String countryId;
    private String currency;
    private BigDecimal price;
    private Long pixelNumber;
    private LocalDateTime publishDate;
}
