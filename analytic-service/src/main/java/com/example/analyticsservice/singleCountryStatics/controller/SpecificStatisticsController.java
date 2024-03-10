package com.example.analyticsservice.singleCountryStatics.controller;

import com.example.analyticsservice.singleCountryStatics.dto.CountrySpecificStatistics;
import com.example.analyticsservice.singleCountryStatics.service.CountrySpecificStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/country-specific-statistics")
public class SpecificStatisticsController {
    private final CountrySpecificStatisticsService countrySpecificStatisticsService;

    @Autowired
    public SpecificStatisticsController(CountrySpecificStatisticsService countrySpecificStatisticsService) {
        this.countrySpecificStatisticsService = countrySpecificStatisticsService;
    }

    @GetMapping("/{tag}")
    public CountrySpecificStatistics getCountryStats(@PathVariable String tag) {
        return countrySpecificStatisticsService.getCountryStats(tag);
    }
}
