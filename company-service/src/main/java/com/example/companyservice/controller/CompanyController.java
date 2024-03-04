package com.example.companyservice.controller;

import com.example.companyservice.dto.request.CompanyRequestDto;
import com.example.companyservice.dto.response.CompanyDto;
import com.example.companyservice.service.CompanyService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World!";
    }

    @PostMapping
    public CompanyDto addCompany(@RequestBody @Valid CompanyRequestDto requestDto) {
        return companyService.save(requestDto);
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyById(@PathVariable String id) {
        return companyService.getById(id);
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies() {
        return companyService.getAll();
    }

    @PutMapping("/{id}")
    public CompanyDto updateCompany(@PathVariable String id,
                                        @RequestBody @Valid CompanyRequestDto requestDto) {
        return companyService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable String id) {
        companyService.deleteById(id);
        return "Company with id = " + id + " is successfully removed";
    }
}

