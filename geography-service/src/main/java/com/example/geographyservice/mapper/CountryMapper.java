package com.example.geographyservice.mapper;

import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.CountryDto;
import com.example.geographyservice.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryDto toDto(Country country) {
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setContinentId(country.getId());
        dto.setPixelNumber(country.getPixelNumber());
        dto.setSoldPixelNumber(country.getSoldPixelNumber());
        return dto;
    }

    public void updateModelFromDto(Country country, CountryRequestDto dto) {
        country.setName(dto.getName());
        country.setPixelNumber(dto.getPixelNumber());
    }


    public Country toModel(CountryRequestDto dto) {
        Country country = new Country();
        country.setName(dto.getName());
        country.setPixelNumber(dto.getPixelNumber());
        return country;
    }
}
