package com.example.analyticsservice.singleCountryStatics.service;

import com.example.analyticsservice.singleCountryStatics.dto.CountrySpecificStatistics;

public interface CountrySpecificStatisticsService {
    CountrySpecificStatistics getCountryStats(String tag);
}
