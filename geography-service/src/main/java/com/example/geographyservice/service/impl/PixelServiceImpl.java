package com.example.geographyservice.service.impl;

import com.example.geographyservice.model.Pixel;
import com.example.geographyservice.repository.PixelRepository;
import com.example.geographyservice.service.PixelService;
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
        List<Pixel> countryPixels = getAllPixelsByCountryTag(countryTag);
        long pixelsUpdated = 0;
        for (Pixel countryPixel : countryPixels) {
            if (countryPixel.getCompanyId() == null && pixelsUpdated < pixelNumber) {
                countryPixel.setCompanyId(companyId);
                pixelsUpdated++;
            }
            if (pixelsUpdated >= pixelNumber) {
                break;
            }
        }
        return pixelRepository.saveAll(countryPixels);
    }
}
