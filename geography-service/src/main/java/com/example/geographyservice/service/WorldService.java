package com.example.geographyservice.service;

public interface WorldService {
    Long getTotalPixelNumber();

    Long getTotalSoldPixelNumber();

    void setPixelNumber(Long pixelNumber);

    void addSoldPixels(Long soldPixelsNumber);
}
