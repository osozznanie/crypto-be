package com.example.geographyservice.controller;

import com.example.geographyservice.service.WorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/world")
@RequiredArgsConstructor
public class WorldController {
    private final WorldService worldService;

    @GetMapping("/total-pixel-number")
    public Long getTotalPixelNumber() {
        return worldService.getTotalPixelNumber();
    }

    @GetMapping("/total-sold-pixel-number")
    public Long getTotalSoldPixelNumber() {
        return worldService.getTotalSoldPixelNumber();
    }

    @PutMapping("/update")
    public String addSoldPixels(@RequestParam Long soldPixelNumber) {
        worldService.addSoldPixels(soldPixelNumber);
        Long remainedPixels = worldService.getTotalPixelNumber()
                - worldService.getTotalSoldPixelNumber();
        return String.format("Total: %s ; Sold: %s ; Remained: %s", worldService.getTotalPixelNumber(),
                worldService.getTotalSoldPixelNumber(), remainedPixels);
    }
}
