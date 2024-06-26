package com.example.geographyservice.controller;

import com.example.geographyservice.dto.request.CountryPurchaseRequestDto;
import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.CountryDto;
import com.example.geographyservice.dto.response.CountryStatsDto;
import com.example.geographyservice.service.CountryService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/{tag}")
    public CountryDto getCountryByTag(@PathVariable String tag) {
        return countryService.getByTag(tag);
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

    @PutMapping("/{tag}/sale")
    public CountryDto updateCountry(@PathVariable String tag,
                                    @RequestBody @Valid CountryPurchaseRequestDto requestDto) {
        return countryService.updateForPurchase(tag, requestDto);
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

    @GetMapping("/no-purchased-pixels")
    public Page<CountryDto> getCountriesWithNoPurchasedPixels(Pageable pageable) {
        return countryService.getCountriesWithNoPurchasedPixels(pageable);
    }
}

