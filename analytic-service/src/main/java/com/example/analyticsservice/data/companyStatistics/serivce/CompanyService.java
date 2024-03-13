package com.example.analyticsservice.data.companyStatistics.serivce;

import com.example.analyticsservice.data.companyStatistics.dto.response.CompanyResponseDto;

import java.util.List;

public interface CompanyService {
    List<CompanyResponseDto> getTopCompanies(int amount);
    Long getAmountOfCompanies();
}
