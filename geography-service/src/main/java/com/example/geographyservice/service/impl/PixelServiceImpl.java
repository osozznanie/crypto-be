package com.example.geographyservice.service.impl;

import com.example.geographyservice.dto.response.PixelDto;
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
    public List<Pixel> setUserToPixels(String userEmail, String companyId, String countryTag, Long pixelNumber) {
        List<Pixel> countryPixels = getAllPixelsByCountryTag(countryTag);
        long pixelsUpdated = 0;
        for (Pixel countryPixel : countryPixels) {
            if (countryPixel.getCompanyId() == null && pixelsUpdated < pixelNumber) {
                countryPixel.setUserEmail(userEmail);
                countryPixel.setCompanyId(companyId);
                pixelsUpdated++;
            }
            if (pixelsUpdated >= pixelNumber) {
                break;
            }
        }
        return pixelRepository.saveAll(countryPixels);
    }

    @Override
    public List<PixelDto> getAllPixelsByIds(List<String> requestIds) {
        return requestIds.stream()
                .map(pixelRepository::findById)
                .map(pixel -> pixel.orElseThrow(() -> new RuntimeException("No pixel is found by id = " + pixel)))
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void saveAllPixels(List<PixelDto> pixelsDto) {
        pixelRepository.saveAll(pixelsDto.stream().map(this::mapToEntity).toList());
    }

    private Pixel mapToEntity(PixelDto pixelDto) {
        return new Pixel(pixelDto.getId(), pixelDto.getCompanyId(),pixelDto.getUserEmail() ,pixelDto.getMarketListingId());
    }

    private PixelDto mapToDto(Pixel pixel) {
        return new PixelDto(pixel.getId(), pixel.getCompanyId(), pixel.getUserEmail(), pixel.getMarketListingId());
    }
}
