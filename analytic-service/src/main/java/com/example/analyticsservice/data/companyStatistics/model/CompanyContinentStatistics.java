package com.example.analyticsservice.data.companyStatistics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyContinentStatistics {
    private String companyName;
    private String continentName;
    private Long purchasedPixels;
}
