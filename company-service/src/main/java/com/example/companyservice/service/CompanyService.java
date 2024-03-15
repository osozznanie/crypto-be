package com.example.companyservice.service;

import com.example.companyservice.dto.request.CompanyRequestDto;
import com.example.companyservice.dto.response.CompanyContinentStatistics;
import com.example.companyservice.dto.response.CompanyDto;
import java.util.List;

public interface CompanyService {
    CompanyDto save(CompanyRequestDto requestDto);

    CompanyDto getById(String id);

    List<CompanyDto> getAll();

    CompanyDto update(String id, CompanyRequestDto requestDto);

    void deleteById(String id);

    List<CompanyContinentStatistics> getTopCompaniesByContinent();
}
