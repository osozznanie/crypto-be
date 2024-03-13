package com.example.analyticsservice.feign;

import com.example.analyticsservice.data.singleCountryStatics.dto.CountryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "geography-service")
public interface GeographyFeign {

    @GetMapping("/api/countries/{tag}")
    CountryDto getCountryByTag(@PathVariable String tag);

    @GetMapping("/api/world/total-pixel-number")
    Long getTotalPixels();

    @GetMapping("/api/world/total-sold-pixel-number")
    Long getTotalSoldPixels();
}
