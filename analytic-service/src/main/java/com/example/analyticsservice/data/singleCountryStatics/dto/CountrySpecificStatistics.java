package com.example.analyticsservice.data.singleCountryStatics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountrySpecificStatistics {
    private String countryName;
    private Long totalPixels;
    private Long remainingPixels;
    private Long soldPixels;
    private double percentageSold;
}
