package com.example.geographyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PixelDto {
    private String id;
    private String companyId;
    private String userEmail;
    private String marketListingId;
}
