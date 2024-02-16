package com.example.transactionservice.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PixelTransactionRequestDto {
    private String senderCompanyId;
    private String receiverCompanyId;
    private String countryId;
    private String currency;
    private BigDecimal price;
    private Long pixelNumber;
    private String transactionType;
    private String transactionId;
}
