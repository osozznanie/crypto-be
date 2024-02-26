package com.example.geographyservice.service.impl;

import com.example.geographyservice.dto.request.ContinentRequestDto;
import com.example.geographyservice.dto.response.ContinentDto;
import com.example.geographyservice.mapper.ContinentMapper;
import com.example.geographyservice.model.Continent;
import com.example.geographyservice.repository.ContinentRepository;
import com.example.geographyservice.service.ContinentService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContinentServiceImpl implements ContinentService {
    private final ContinentRepository continentRepository;
    private final ContinentMapper continentMapper;

    @Override
    @Transactional
    public ContinentDto save(ContinentRequestDto requestDto) {
        Continent continent = continentMapper.toModel(requestDto);
        return continentMapper.toDto(continentRepository.save(continent));
    }

    @Override
    public ContinentDto getById(String id) {
        return continentMapper.toDto(continentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No continent is found by id = " + id)
        ));
    }

    @Override
    public List<ContinentDto> getAll() {
        return continentRepository.findAll().stream()
                .map(continentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ContinentDto update(String id, ContinentRequestDto requestDto) {
        Continent continentForUpdate = continentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No continent is found by id = " + id)
        );
        continentMapper.updateModelFromDto(continentForUpdate, requestDto);
        continentRepository.save(continentForUpdate);
        return continentMapper.toDto(continentForUpdate);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        continentRepository.deleteById(id);
    }
}