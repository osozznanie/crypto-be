package com.example.analyticsservice.feign;

import com.example.analyticsservice.data.companyStatistics.dto.request.CompanyRequestDto;
import com.example.analyticsservice.data.companyStatistics.model.CompanyContinentStatistics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "company-service")
public interface CompanyFeign {

    @GetMapping("/api/companies")
    List<CompanyRequestDto> getAllCompanies();

    @GetMapping("/api/companies/topCompaniesByContinent")
    List<CompanyContinentStatistics> getTopCompaniesByContinent();

}
