package com.example.geographyservice.dto.response;

import lombok.Data;

@Data
public class CountryDto {
    private String id;
    private String name;
    private String continentId;
    private Long pixelNumber;
    private Long soldPixelNumber;
}
