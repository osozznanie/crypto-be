package com.example.marketplaceservice.controller;

import com.example.marketplaceservice.dto.request.MarketListingRequestDto;
import com.example.marketplaceservice.dto.response.MarketListingDto;
import com.example.marketplaceservice.feigns.UserFeign;
import com.example.marketplaceservice.service.MarketListingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/market-listings")
@RequiredArgsConstructor
public class MarketListingController {
    private final MarketListingService marketListingService;
    private final UserFeign userFeign;

    @PostMapping
    public MarketListingDto addMarketListing(@RequestBody @Valid MarketListingRequestDto requestDto) {
        return marketListingService.save(requestDto);
    }

    @GetMapping("/{id}")
    public MarketListingDto getMarketListingById(@PathVariable String id) {
        return marketListingService.getById(id);
    }

    @GetMapping
    public List<MarketListingDto> getAllMarketListings() {
        return marketListingService.getALl();
    }

    @PutMapping("/{id}")
    public MarketListingDto updateMarketListing(@PathVariable String id,
                                                @RequestBody @Valid MarketListingRequestDto requestDto) {
        return marketListingService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteMarketListing(@PathVariable String id) {
        marketListingService.deleteById(id);
        return String.format("Market listing with id = %s is successfully removed", id);
    }
}
