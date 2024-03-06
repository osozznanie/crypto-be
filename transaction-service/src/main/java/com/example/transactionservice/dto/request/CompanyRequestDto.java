package com.example.transactionservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public CompanyRequestDto(String userEmail, String name,
                             String logoLink, String websiteLink, String description) {
        this.userEmail = userEmail;
        this.name = name;
        this.logoLink = logoLink;
        this.websiteLink = websiteLink;
        this.description = description;
        this.pixelNumber = 0L;
    }
}