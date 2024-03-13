package com.example.analyticsservice.data.singleCountryStatics.service;

import com.example.analyticsservice.data.singleCountryStatics.dto.CountrySpecificStatistics;

public interface CountrySpecificStatisticsService {
    CountrySpecificStatistics getCountryStats(String tag);
}
