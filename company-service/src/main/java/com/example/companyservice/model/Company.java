package com.example.companyservice.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("companies")
public class Company {
    @Id
    private String id;
    private String userEmail;
    @Indexed(unique = true)
    private String name;
    private String logoLink;
    @Indexed(unique = true)
    private String websiteLink;
    private String description;
    private Long pixelNumbers = 0L;
}
