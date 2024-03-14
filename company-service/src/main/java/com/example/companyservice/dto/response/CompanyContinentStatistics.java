package com.example.companyservice.dto.response;

import lombok.Data;

@Data
public class CompanyContinentStatistics {
    private String companyName;
    private String continentName;
    private Long purchasedPixels;
}
