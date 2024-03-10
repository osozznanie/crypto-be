package com.example.analyticsservice.worldStatistics.service;

import com.example.analyticsservice.worldStatistics.dto.WorldStatistics;

public interface WorldStatisticsService {
    Long getTotalPixels();
    Long getTotalSoldPixels();
    WorldStatistics getWorldStatistics();
}
