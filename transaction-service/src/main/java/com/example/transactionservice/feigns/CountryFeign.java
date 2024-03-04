package com.example.transactionservice.feigns;

import com.example.transactionservice.dto.request.CountryPurchaseRequestDto;
import com.example.transactionservice.dto.response.CountryDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "geography-service", path = "/api/countries")
public interface CountryFeign {
    @PutMapping("/{tag}/sale")
    CountryDto updateCountryForPurchase(@PathVariable String tag,
                                        @RequestBody @Valid CountryPurchaseRequestDto requestDto);

    @GetMapping("/{id}")
    CountryDto getCountryById(@PathVariable String id);
}
