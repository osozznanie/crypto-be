package com.example.analyticsservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "geography-service")
@RequestMapping("/api/world")
public interface WorldFeign {

    @GetMapping("/total-pixel-number")
    Long getTotalPixels();

    @GetMapping("/total-sold-pixel-number")
    Long getTotalSoldPixels();
}

