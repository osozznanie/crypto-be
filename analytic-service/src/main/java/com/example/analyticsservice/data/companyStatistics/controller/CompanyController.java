package com.example.analyticsservice.data.companyStatistics.controller;

import com.example.analyticsservice.data.companyStatistics.dto.response.CompanyResponseDto;
import com.example.analyticsservice.data.companyStatistics.serivce.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies-statistics")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/amount")
    public Long getAmountOfCompanies() {
        return companyService.getAmountOfCompanies();
    }

    @GetMapping("/top20")
    public List<CompanyResponseDto> getTop20Companies() {
        return companyService.getTopCompanies(20);
    }

    @GetMapping("/top3")
    public List<CompanyResponseDto> getTop3Companies() {
        return companyService.getTopCompanies(3);
    }

//    @GetMapping("/{tag}")
//    public CompanyResponseDto getCompanyStats(@PathVariable String tag) {
//        return companyService.getCompanyStats(tag);
//    }
}
