package com.example.geographyservice.service;

public interface WorldService {
    Long getTotalPixelNumber();

    Long getTotalSoldPixelNumber();

    void addSoldPixels(Long soldPixelsNumber);
}
