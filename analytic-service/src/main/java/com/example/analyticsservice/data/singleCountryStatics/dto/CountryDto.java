package com.example.analyticsservice.data.singleCountryStatics.dto;

import lombok.Data;

@Data
public class CountryDto {
    private String id;
    private String name;
    private String tag;
    private String continentId;
    private Long pixelNumber;
    private Long soldPixelNumber;

    public Long getRemainingPixels() {
        return pixelNumber - soldPixelNumber;
    }
    public double getPercentageSold() {
        return (double) ((soldPixelNumber * 100) / pixelNumber);
    }
}
