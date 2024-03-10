package com.example.analyticsservice.singleCountryStatics.service.impl;

import com.example.analyticsservice.feign.CountryFeign;
import com.example.analyticsservice.singleCountryStatics.dto.CountryDto;
import com.example.analyticsservice.singleCountryStatics.dto.CountrySpecificStatistics;
import com.example.analyticsservice.singleCountryStatics.service.CountrySpecificStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountrySpecificStatisticsServiceImpl implements CountrySpecificStatisticsService {
    private final CountryFeign countryFeign;

    @Override
    public CountrySpecificStatistics getCountryStats(String tag) {
        if (tag == null || tag.isEmpty()) {
            throw new IllegalArgumentException("Tag cannot be null or empty!");
        }

        CountryDto countryByTagDto = countryFeign.getCountryByTag(tag);
        if (countryByTagDto == null) {
            return new CountrySpecificStatistics();
        }

        return CountrySpecificStatistics.builder()
                .countryName(countryByTagDto.getName())
                .totalPixels(countryByTagDto.getPixelNumber())
                .remainingPixels(countryByTagDto.getRemainingPixels())
                .soldPixels(countryByTagDto.getSoldPixelNumber())
                .percentageSold(countryByTagDto.getPercentageSold())
                .build();
    }
}
