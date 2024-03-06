package com.example.companyservice.mapper;

import com.example.companyservice.dto.request.CompanyRequestDto;
import com.example.companyservice.dto.response.CompanyDto;
import com.example.companyservice.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyDto toDto(Company company) {
        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setUserEmail(company.getUserEmail());
        dto.setName(company.getName());
        dto.setLogoLink(company.getLogoLink());
        dto.setWebsiteLink(company.getWebsiteLink());
        dto.setDescription(company.getDescription());
        dto.setPixelNumber(company.getPixelNumbers());
        return dto;
    }

    public void updateModelFromDto(Company company, CompanyRequestDto dto) {
        company.setUserEmail(dto.getUserEmail());
        company.setName(dto.getName());
        company.setLogoLink(dto.getLogoLink());
        company.setWebsiteLink(dto.getWebsiteLink());
        company.setDescription(dto.getDescription());
        company.setPixelNumbers(dto.getPixelNumber());
    }

    public Company toModel(CompanyRequestDto dto) {
        Company company = new Company();
        updateModelFromDto(company, dto);
        return company;
    }
}
