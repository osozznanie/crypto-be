package com.example.transactionservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PixelTransactionDto {
    private String id;
    private String senderCompanyId;
    private String receiverCompanyId;
    private String senderUserEmail;
    private String receiverUserEmail;
    private String countryTag;
    private String currency;
    private BigDecimal price;
    private Long pixelNumber;
    private String transactionType;
    private LocalDateTime transactionDate;
    private String transactionId;
}
