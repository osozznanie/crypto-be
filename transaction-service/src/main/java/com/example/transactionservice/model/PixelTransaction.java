package com.example.transactionservice.model;

import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("pixel_transactions")
public class PixelTransaction {
    @Id
    private String id;
    private String senderCompanyId;
    private String receiverCompanyId;
    private String countryTag;
    private String currency;
    private BigDecimal price;
    private Long pixelNumber;
    private String transactionType;
    private LocalDateTime transactionDate;
    private String transactionId;
}
