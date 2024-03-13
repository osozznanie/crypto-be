package com.example.analyticsservice.data.companyStatistics.serivce.impl;

import com.example.analyticsservice.data.companyStatistics.dto.request.CompanyRequestDto;
import com.example.analyticsservice.data.companyStatistics.dto.response.CompanyResponseDto;
import com.example.analyticsservice.data.companyStatistics.mapper.CompanyMapper;
import com.example.analyticsservice.data.companyStatistics.serivce.CompanyService;
import com.example.analyticsservice.feign.CompanyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyFeign companyFeign;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyFeign companyFeign, CompanyMapper companyMapper) {
        this.companyFeign = companyFeign;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyResponseDto> getTopCompanies(int amount) {
        List<CompanyRequestDto> companies = companyFeign.getAllCompanies();
        companies.sort(Comparator.comparing(CompanyRequestDto::getPixelNumber));

        if (amount > companies.size()) {
            return companies.stream()
                    .map(companyMapper::toResponseDto)
                    .toList();
        }

        return companies.subList(0, amount).stream()
                .map(companyMapper::toResponseDto)
                .toList();
    }

    @Override
    public Long getAmountOfCompanies() {
        return (long) companyFeign.getAllCompanies().size();
    }
}
