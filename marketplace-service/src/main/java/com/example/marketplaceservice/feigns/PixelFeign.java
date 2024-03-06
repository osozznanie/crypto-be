package com.example.marketplaceservice.feigns;

import com.example.marketplaceservice.dto.request.GetPixelsRequestDto;
import com.example.marketplaceservice.dto.response.PixelDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "geography-service", path = "/api/pixels")
public interface PixelFeign {

    @PutMapping
    List<PixelDto> getAllPixelsByIds(@RequestBody GetPixelsRequestDto pixelRequestDto);

    @PostMapping
    void saveAllPixels(@RequestBody List<PixelDto> pixelsDto);

}
