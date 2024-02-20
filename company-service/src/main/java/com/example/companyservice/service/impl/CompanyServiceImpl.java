package com.example.companyservice.service.impl;

import com.example.companyservice.dto.request.CompanyRequestDto;
import com.example.companyservice.dto.response.CompanyDto;
import com.example.companyservice.mapper.CompanyMapper;
import com.example.companyservice.model.Company;
import com.example.companyservice.repository.CompanyRepository;
import com.example.companyservice.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    @Transactional
    public CompanyDto save(CompanyRequestDto requestDto) {
        Company company = companyMapper.toModel(requestDto);
        return companyMapper.toDto(companyRepository.save(company));
    }

    @Override
    public CompanyDto getById(String id) {
        return companyMapper.toDto(companyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No company is found by id = " + id)
        ));
    }

    @Override
    public List<CompanyDto> getAll() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CompanyDto update(String id, CompanyRequestDto requestDto) {
        Company companyForUpdate = companyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No continent is found by id = " + id)
        );
        companyMapper.updateModelFromDto(companyForUpdate, requestDto);
        companyRepository.save(companyForUpdate);
        return companyMapper.toDto(companyForUpdate);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        companyRepository.deleteById(id);
    }
}
