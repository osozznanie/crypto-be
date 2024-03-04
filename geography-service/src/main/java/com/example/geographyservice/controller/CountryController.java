package com.example.geographyservice.controller;

import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.CountryDto;
import com.example.geographyservice.dto.response.CountryStatsDto;
import com.example.geographyservice.service.CountryService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping
    public CountryDto addCountry(@RequestBody @Valid CountryRequestDto requestDto) {
        return countryService.save(requestDto);
    }

    @GetMapping("/{id}")
    public CountryDto getCountryById(@PathVariable String id) {
        return countryService.getById(id);
    }

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryService.getAll();
    }

    @PutMapping("/{id}")
    public CountryDto updateCountry(@PathVariable String id,
                                    @RequestBody @Valid CountryRequestDto requestDto) {
        return countryService.update(id, requestDto);
    }

    @GetMapping("/stats/{tag}")
    public CountryStatsDto getCountryStats(@PathVariable String tag) {
        return countryService.getCountryStats(tag);
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable String id) {
        countryService.deleteById(id);
        return "Country with id = " + id + " is successfully removed";
    }
}

