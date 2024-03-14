package com.example.analyticsservice.data.companyStatistics.controller;

import com.example.analyticsservice.data.companyStatistics.dto.response.CompanyResponseDto;
import com.example.analyticsservice.data.companyStatistics.serivce.CompanyStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies-statistics")
public class CompanyController {
    private final CompanyStatisticsService companyStatisticsService;

    @GetMapping("/amount")
    public Long getAmountOfCompanies() {
        return companyStatisticsService.getAmountOfCompanies();
    }

    @GetMapping("/top20")
    public List<CompanyResponseDto> getTop20Companies() {
        return companyStatisticsService.getTopCompanies(20);
    }

    @GetMapping("/top3")
    public List<CompanyResponseDto> getTop3Companies() {
        return companyStatisticsService.getTopCompanies(3);
    }

//    @GetMapping("/{tag}")
//    public CompanyResponseDto getCompanyStats(@PathVariable String tag) {
//        return companyStatisticsService.getCompanyStats(tag);
//    }

    @GetMapping("/top-companies-by-continent")
    public List<CompanyResponseDto> getTopCompaniesByContinent() {
        return companyStatisticsService.getTopCompaniesByContinent();
    }
}
