package com.example.marketplaceservice.feigns;

import com.example.marketplaceservice.dto.response.PixelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "geography-service")
public interface PixelFeign {

    @GetMapping("/api/pixels")
    List<PixelDto> getAllPixelsByIds(List<String> requestIds);

    @PostMapping("/api/pixels")
    void saveAllPixels(List<PixelDto> pixelsDto);

}
