package com.example.marketplaceservice.model;

import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("market_listings")
public class MarketListing {
    @Id
    private String id;
    private String userEmail;
    private String countryId;
    private String currency;
    private BigDecimal price;
    private Long pixelNumbers;
    private LocalDateTime publishDate;
}
