package com.example.companyservice.dto.response;

import lombok.Data;

@Data
public class CompanyDto {
    private String id;
    private String userId;
    private String name;
    private String logoLink;
    private String websiteLink;
    private String description;
    private Long pixelNumber;
}
