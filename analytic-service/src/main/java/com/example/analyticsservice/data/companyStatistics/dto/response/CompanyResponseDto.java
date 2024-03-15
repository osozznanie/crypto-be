package com.example.analyticsservice.data.companyStatistics.dto.response;

import lombok.Data;

@Data
public class CompanyResponseDto {
    private String name;
    private Long totalPixels;
    private Long continentDomination;
    private Long worldDomination;
}
