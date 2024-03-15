package com.example.analyticsservice.data.worldStatistics.service;

import com.example.analyticsservice.data.worldStatistics.dto.WorldStatistics;

public interface WorldStatisticsService {
    Long getTotalPixels();
    Long getTotalSoldPixels();
    WorldStatistics getWorldStatistics();
}
