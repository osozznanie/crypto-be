package com.example.geographyservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("pixels")
public class Pixel {
    private String id;
    private String companyId;
}
