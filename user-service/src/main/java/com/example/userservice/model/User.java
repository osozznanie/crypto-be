package com.example.userservice.model;

import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    private String walletAddress;
    private BigDecimal walletBalance;
}
