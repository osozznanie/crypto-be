package com.example.transactionservice.dto.response;

import lombok.Data;

@Data
public class CompanyDto {
    private String id;
    private String userEmail;
    private String name;
    private String logoLink;
    private String websiteLink;
    private String description;
    private Long pixelNumber;
}