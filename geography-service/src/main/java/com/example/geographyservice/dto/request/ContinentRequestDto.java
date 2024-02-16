package com.example.geographyservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContinentRequestDto {
    @NotBlank
    private String name;
    private Long pixelNumber;
}
