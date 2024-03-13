package com.example.analyticsservice.data.worldStatistics.controller;

import com.example.analyticsservice.data.worldStatistics.dto.WorldStatistics;
import com.example.analyticsservice.data.worldStatistics.service.WorldStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/world-statistics")
public class WorldStatisticsController {
    private final WorldStatisticsService worldStatisticsService;

    public WorldStatisticsController(WorldStatisticsService worldStatisticsService) {
        this.worldStatisticsService = worldStatisticsService;
    }

    @GetMapping("/total-pixels")
    public Long getTotalPixels() {
        return worldStatisticsService.getTotalPixels();
    }

    @GetMapping("/total-sold-pixels")
    public Long getTotalSoldPixels() {
        return worldStatisticsService.getTotalSoldPixels();
    }

    @GetMapping
    public WorldStatistics getWorldStatistics() {
        return worldStatisticsService.getWorldStatistics();
    }
}
