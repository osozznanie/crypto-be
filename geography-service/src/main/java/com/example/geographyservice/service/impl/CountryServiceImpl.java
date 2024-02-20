package com.example.geographyservice.service.impl;

import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.CountryDto;
import com.example.geographyservice.mapper.CountryMapper;
import com.example.geographyservice.model.Country;
import com.example.geographyservice.repository.ContinentRepository;
import com.example.geographyservice.repository.CountryRepository;
import com.example.geographyservice.service.CountryService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ContinentRepository continentRepository;
    private final CountryMapper countryMapper;

    @Override
    @Transactional
    public CountryDto save(CountryRequestDto requestDto) {
        Country country = countryMapper.toModel(requestDto);
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public CountryDto getById(String id) {
        return countryMapper.toDto(countryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No country is found by id = " + id)
        ));
    }

    @Override
    public List<CountryDto> getAll() {
        return countryRepository.findAll().stream()
                .map(countryMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CountryDto update(String id, CountryRequestDto requestDto) {
        Country countryForUpdate = countryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No country is found by id = " + id)
        );
        countryMapper.updateModelFromDto(countryForUpdate, requestDto);
        countryRepository.save(countryForUpdate);
        return countryMapper.toDto(countryForUpdate);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        countryRepository.deleteById(id);
    }
}
