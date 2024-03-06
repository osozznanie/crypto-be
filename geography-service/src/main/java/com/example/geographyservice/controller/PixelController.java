package com.example.geographyservice.controller;

import com.example.geographyservice.dto.request.GetPixelsRequestDto;
import com.example.geographyservice.dto.response.PixelDto;
import com.example.geographyservice.service.PixelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pixels")
public class PixelController {
    private final PixelService pixelService;

    @PutMapping
    List<PixelDto> getAllPixelsByIds(@RequestBody GetPixelsRequestDto requestDto) {
        return pixelService.getAllPixelsByIds(requestDto.getPixelIds());
    }

    @PostMapping
    void saveAllPixels(@RequestBody List<PixelDto> pixelsDto) {
        pixelService.saveAllPixels(pixelsDto);
    }
}
