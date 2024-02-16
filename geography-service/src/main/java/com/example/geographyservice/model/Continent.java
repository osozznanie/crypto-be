package com.example.geographyservice.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("continents")
public class Continent {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Long pixelNumber;
    private Long soldPixelNumber = 0L;
}
