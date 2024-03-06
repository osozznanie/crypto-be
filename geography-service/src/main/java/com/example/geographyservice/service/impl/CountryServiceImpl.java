package com.example.geographyservice.service.impl;

import com.example.geographyservice.dto.request.ContinentPurchaseRequestDto;
import com.example.geographyservice.dto.request.ContinentRequestDto;
import com.example.geographyservice.dto.request.CountryPurchaseRequestDto;
import com.example.geographyservice.dto.request.CountryRequestDto;
import com.example.geographyservice.dto.response.ContinentDto;
import com.example.geographyservice.dto.response.CountryDto;
import com.example.geographyservice.dto.response.CountryStatsDto;
import com.example.geographyservice.mapper.CountryMapper;
import com.example.geographyservice.model.Country;
import com.example.geographyservice.model.Pixel;
import com.example.geographyservice.repository.CountryRepository;
import com.example.geographyservice.service.ContinentService;
import com.example.geographyservice.service.CountryService;
import com.example.geographyservice.service.PixelService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ContinentService continentService;
    private final PixelService pixelService;
    private final CountryMapper countryMapper;

    @Override
    @Transactional
    public CountryDto save(CountryRequestDto requestDto) {
        Country country = countryMapper.toModel(requestDto);
        countryRepository.save(country);
        pixelService.createPixels(country.getTag(), country.getPixelNumber());
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
        Long countryPixelNumber = countryForUpdate.getPixelNumber();
        countryMapper.updateModelFromDto(countryForUpdate, requestDto);
        countryRepository.save(countryForUpdate);
        if (!countryPixelNumber.equals(requestDto.getPixelNumber())) {
            ContinentDto continentDto = continentService.getById(requestDto.getContinentId());
            Long continentUpdatedPixelNumber = continentDto.getPixelNumber()
                    + (countryPixelNumber < requestDto.getPixelNumber()
                    ? requestDto.getPixelNumber() : -requestDto.getPixelNumber());
            continentService.update(requestDto.getContinentId(),
                    new ContinentRequestDto(continentDto.getName(), continentUpdatedPixelNumber));
        }
        return countryMapper.toDto(countryForUpdate);
    }

    @Override
    @Transactional
    public CountryDto updateForPurchase(String tag, CountryPurchaseRequestDto requestDto) {
        Country countryForUpdate = countryRepository.findByTag(tag).orElseThrow(
                () -> new EntityNotFoundException("No country is found by tag = " + tag)
        );
        countryForUpdate.setSoldPixelNumber(countryForUpdate.getSoldPixelNumber() + requestDto.getPixelNumber());
        countryRepository.save(countryForUpdate);
        continentService.updateForPurchase(requestDto.getContinentId(),
                new ContinentPurchaseRequestDto(requestDto.getPixelNumber()));
        pixelService.setUserToPixels(requestDto.getUserEmail(),requestDto.getCompanyId(), tag, requestDto.getPixelNumber());
        return countryMapper.toDto(countryForUpdate);
    }

    @Override
    public CountryStatsDto getCountryStats(String countryTag) {
        CountryStatsDto statsDto = new CountryStatsDto();
        Country country = countryRepository.findByTag(countryTag).orElseThrow(
                () -> new EntityNotFoundException("No country is found by tag = " + countryTag)
        );
        List<Pixel> countryPixels = pixelService.getAllPixelsByCountryTag(countryTag);
        countryPixels.forEach(pixel -> pixel.setCompanyId("test_ID"));
        statsDto.setCountryName(country.getName());
        statsDto.setCountryPixels(countryPixels);
        return statsDto;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        countryRepository.deleteById(id);
    }

    @Override
    public CountryDto getByTag(String tag) {
        return countryMapper.toDto(countryRepository.findByTag(tag).orElseThrow(
                () -> new EntityNotFoundException("No country is found by tag = " + tag)
        ));
    }
}
