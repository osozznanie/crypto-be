package com.example.geographyservice.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("world")
public class World {
    @Id
    private String id = "crypto-world";
    private Long totalPixelNumber = 12_850_500L;
    private Long soldPixelNumber = 0L;
}
