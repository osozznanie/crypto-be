package com.example.geographyservice.service;

import com.example.geographyservice.dto.response.PixelDto;
import com.example.geographyservice.model.Pixel;

import java.util.List;

public interface PixelService {
    void createPixels(String tag, Long num);

    List<Pixel> getAllPixelsByCountryTag(String countryTag);

    List<Pixel> getAllPixelsByCompanyId(String companyId);

    List<Pixel> setUserToPixels(String userEmail, String companyId, String countryTag, Long pixelNumber);

    List<PixelDto> getAllPixelsByIds(List<String> requestIds);

    void saveAllPixels(List<PixelDto> pixelsDto);
}
