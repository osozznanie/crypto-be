package com.example.geographyservice.controller;

import com.example.geographyservice.dto.response.PixelDto;
import com.example.geographyservice.service.PixelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pixels")
public class PixelController {
    private final PixelService pixelService;

    @GetMapping
    List<PixelDto> getAllPixelsByIds(List<String> requestIds) {
        return pixelService.getAllPixelsByIds(requestIds);
    }

    @PostMapping
    void saveAllPixels(List<PixelDto> pixelsDto) {
        pixelService.saveAllPixels(pixelsDto);
    }
}
