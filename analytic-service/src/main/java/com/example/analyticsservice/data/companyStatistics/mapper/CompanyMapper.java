package com.example.analyticsservice.data.companyStatistics.mapper;

import com.example.analyticsservice.data.companyStatistics.dto.request.CompanyRequestDto;
import com.example.analyticsservice.data.companyStatistics.dto.response.CompanyResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyResponseDto toResponseDto(CompanyRequestDto companyDto) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setName(companyDto.getName());
        companyResponseDto.setTotalPixels(companyDto.getPixelNumber());
        companyResponseDto.setContinentDomination((10000 * 100) / companyDto.getPixelNumber());
        companyResponseDto.setWorldDomination((1000000 * 100) / companyDto.getPixelNumber());
        return companyResponseDto;
    }

    public CompanyRequestDto toRequestDto(CompanyResponseDto companyDto) {
        CompanyRequestDto companyRequestDto = new CompanyRequestDto();
        companyRequestDto.setName(companyDto.getName());
        companyRequestDto.setPixelNumber(companyDto.getTotalPixels());
        return companyRequestDto;
    }
}
