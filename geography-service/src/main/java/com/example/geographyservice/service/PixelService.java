package com.example.geographyservice.service;

import com.example.geographyservice.model.Pixel;
import java.util.List;

public interface PixelService {
    void createPixels(String tag, Long num);

    List<Pixel> getAllPixelsByCountryTag(String countryTag);

    List<Pixel> getAllPixelsByCompanyId(String companyId);

    List<Pixel> setCompanyToPixels(String companyId, String countryTag, Long pixelNumber);
}
