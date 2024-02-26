package com.example.geographyservice.service;

import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.CountryDto;
import java.util.List;

public interface CountryService {
    CountryDto save(CountryRequestDto requestDto);

    CountryDto getById(String id);

    List<CountryDto> getAll();

    CountryDto update(String id, CountryRequestDto requestDto);

    void deleteById(String id);
}
