package com.example.geographyservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CountryRequestDto {
    @NotBlank
    private String name;
    @NotNull
    private String continentId;
    private Long pixelNumber;
}
