package com.example.geographyservice.service;

import com.example.geographyservice.model.Pixel;
import java.util.List;

public interface PixelService {
    void createPixels(String tag, Long num);

    List<Pixel> getAllPixelsByCountryTag(String countryTag);
}
