package com.example.geographyservice.dto.response;

import com.example.geographyservice.model.Pixel;
import java.util.List;
import lombok.Data;

@Data
public class CountryStatsDto {
    private String countryName;
    private List<Pixel> countryPixels;
}
