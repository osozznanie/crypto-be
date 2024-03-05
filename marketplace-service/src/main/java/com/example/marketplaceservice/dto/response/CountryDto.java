package com.example.marketplaceservice.dto.response;

import lombok.Data;

@Data
public class CountryDto {
    private String id;
    private String name;
    private String tag;
    private String continentId;
    private Long pixelNumber;
    private Long soldPixelNumber;
}
