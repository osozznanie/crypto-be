package com.example.geographyservice.service.impl;

import com.example.geographyservice.model.Pixel;
import com.example.geographyservice.repository.PixelRepository;
import com.example.geographyservice.service.PixelService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixelServiceImpl implements PixelService {
    private final PixelRepository pixelRepository;

    @Override
    public void createPixels(String tag, Long num) {
        List<Pixel> pixels = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            Pixel pixel = new Pixel();
            pixel.setId(tag + '-' + i);
            pixels.add(pixel);
        }
        pixelRepository.saveAll(pixels);
    }

    @Override
    public List<Pixel> getAllPixelsByCountryTag(String countryTag) {
        return pixelRepository.findAllByCountryTag(countryTag);
    }

    @Override
    public List<Pixel> getAllPixelsByCompanyId(String companyId) {
        return pixelRepository.findAllByCompanyId(companyId);
    }

    @Override
    public List<Pixel> setCompanyToPixels(String companyId, String countryTag, Long pixelNumber) {
        List<Pixel> companyPixels = new ArrayList<>();
        List<Pixel> countryPixels = getAllPixelsByCountryTag(countryTag);
        for (Pixel countryPixel : countryPixels) {
            if (countryPixel.getCompanyId() == null) {
                for (int j = 0; j < pixelNumber; j++) {
                    companyPixels.get(j).setCompanyId(companyId);
                    companyPixels.add(companyPixels.get(j));
                }
                break;
            }
        }
        return pixelRepository.saveAll(companyPixels);
    }
}
