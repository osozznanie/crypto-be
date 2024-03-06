package com.example.transactionservice.feigns;

import com.example.transactionservice.dto.request.CompanyRequestDto;
import com.example.transactionservice.dto.response.CompanyDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "company-service", path = "/api/companies")
public interface CompanyFeign {

    @PostMapping
    CompanyDto addCompany(@RequestBody @Valid CompanyRequestDto requestDto);

    @GetMapping("/{id}")
    CompanyDto getCompanyById(@PathVariable String id);
}
