package com.example.marketplaceservice.feigns;

import com.example.marketplaceservice.dto.response.CompanyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "company-service")
public interface CompanyFeign {

    @GetMapping("/api/companies/{id}")
    CompanyDto getCompanyById(@PathVariable String id);

    @PutMapping("/api/companies/{id}/")
    CompanyDto updateCompanyPixelNumber(@PathVariable String id, @RequestBody CompanyDto companyDto);
}
