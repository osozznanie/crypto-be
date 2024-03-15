package com.example.analyticsservice.data.companyStatistics.dto.request;

import lombok.Data;

@Data
public class CompanyRequestDto {
    private String id;
    private String userEmail;
    private String name;
    private String logoLink;
    private String websiteLink;
    private String description;
    private Long pixelNumber;
}
