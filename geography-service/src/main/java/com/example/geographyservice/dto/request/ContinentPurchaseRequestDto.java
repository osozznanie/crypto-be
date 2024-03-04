package com.example.geographyservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinentPurchaseRequestDto {
    @NotNull
    private Long pixelNumber;
}
