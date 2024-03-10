package com.example.analyticsservice.feign;

import com.example.analyticsservice.singleCountryStatics.dto.CountryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "geography-service")
public interface CountryFeign {

    @GetMapping("/api/countries/{tag}")
    CountryDto getCountryByTag(@PathVariable String tag);
}
