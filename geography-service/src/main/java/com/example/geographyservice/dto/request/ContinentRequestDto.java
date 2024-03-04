package com.example.geographyservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinentRequestDto {
    @NotBlank
    private String name;
    @NotNull
    private Long pixelNumber;
}
