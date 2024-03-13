package com.example.analyticsservice.worldStatistics.service.impl;

import com.example.analyticsservice.feign.GeographyFeign;
import com.example.analyticsservice.worldStatistics.dto.WorldStatistics;
import com.example.analyticsservice.worldStatistics.service.WorldStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldStatisticsServiceImpl implements WorldStatisticsService {
    private final GeographyFeign worldFeign;

    @Override
    public Long getTotalPixels() {
        return worldFeign.getTotalPixels();
    }

    @Override
    public Long getTotalSoldPixels() {
        return worldFeign.getTotalSoldPixels();
    }

    @Override
    public WorldStatistics getWorldStatistics() {
        WorldStatistics worldStatistics = WorldStatistics.builder()
                .totalPixels(getTotalPixels())
                .soldPixels(getTotalSoldPixels())
                .build();

        worldStatistics.setRemainingPixels(worldStatistics.remainingPixels());
        worldStatistics.setPercentageSold(worldStatistics.getPercentageSold());

        return worldStatistics;
    }
}
