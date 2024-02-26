package com.example.geographyservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("countries")
public class Country {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String continentId;
    private Long pixelNumber;
    private Long soldPixelNumber = 0L;
}
