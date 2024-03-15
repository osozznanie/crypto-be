package com.example.analyticsservice.data.worldStatistics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorldStatistics {
    private Long totalPixels;
    private Long remainingPixels;
    private Long soldPixels;
    private double percentageSold;

    public double getPercentageSold() {
        return ((double) (soldPixels * 100) / totalPixels);
    }

    public Long remainingPixels() {
        return totalPixels - soldPixels;
    }
}
