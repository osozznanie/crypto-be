package com.example.geographyservice.dto.response;

import lombok.Data;

@Data
public class ContinentDto {
    private String id;
    private String name;
    private Long pixelNumber;
    private Long soldPixelNumber;
}
