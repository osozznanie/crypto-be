package com.example.companyservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyRequestDto {
    @NotNull
    private String userEmail;
    @NotBlank
    private String name;
    private String logoLink;
    @NotBlank
    private String websiteLink;
    private String description;
    private Long pixelNumber;
}
