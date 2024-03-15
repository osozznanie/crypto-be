package com.example.geographyservice.service;

import com.example.geographyservice.dto.request.CountryPurchaseRequestDto;
import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.CountryDto;
import com.example.geographyservice.dto.response.CountryStatsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {
    CountryDto save(CountryRequestDto requestDto);

    CountryDto getById(String id);

    List<CountryDto> getAll();

    CountryDto update(String id, CountryRequestDto requestDto);

    CountryDto updateForPurchase(String tag, CountryPurchaseRequestDto requestDto);

    CountryStatsDto getCountryStats(String countryTag);

    void deleteById(String id);

    CountryDto getByTag(String tag);

    Page<CountryDto> getCountriesWithNoPurchasedPixels(Pageable pageable);
}
