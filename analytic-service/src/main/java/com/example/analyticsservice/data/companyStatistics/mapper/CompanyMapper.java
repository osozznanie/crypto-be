package com.example.analyticsservice.data.companyStatistics.mapper;

import com.example.analyticsservice.data.companyStatistics.dto.request.CompanyRequestDto;
import com.example.analyticsservice.data.companyStatistics.dto.response.CompanyResponseDto;
import com.example.analyticsservice.data.companyStatistics.model.CompanyContinentStatistics;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyResponseDto toResponseDto(CompanyRequestDto companyDto) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setName(companyDto.getName());
        companyResponseDto.setTotalPixels(companyDto.getPixelNumber());
        companyResponseDto.setContinentDomination((companyResponseDto.getTotalPixels() / 100000) * 100);
        companyResponseDto.setWorldDomination((companyResponseDto.getTotalPixels() / 12825500) * 100);
        return companyResponseDto;
    }

    public CompanyRequestDto toRequestDto(CompanyResponseDto companyDto) {
        CompanyRequestDto companyRequestDto = new CompanyRequestDto();
        companyRequestDto.setName(companyDto.getName());
        companyRequestDto.setPixelNumber(companyDto.getTotalPixels());
        return companyRequestDto;
    }

    public CompanyResponseDto fromCompanyContinentStatisticsToCompanyResponseDto(CompanyContinentStatistics companyContinentStatistics) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setName(companyContinentStatistics.getCompanyName());
        companyResponseDto.setTotalPixels(companyContinentStatistics.getPurchasedPixels());
        companyResponseDto.setContinentDomination((companyContinentStatistics.getPurchasedPixels() / 100000) * 100);
        companyResponseDto.setWorldDomination((companyContinentStatistics.getPurchasedPixels() / 12825500) * 100);
        return companyResponseDto;
    }
}
