package com.example.marketplaceservice.service;

import com.example.marketplaceservice.dto.request.MarketListingRequestDto;
import com.example.marketplaceservice.dto.response.MarketListingDto;
import java.util.List;

public interface MarketListingService {
    MarketListingDto save(MarketListingRequestDto requestDto);

    MarketListingDto getById(String id);

    List<MarketListingDto> getALl();

    MarketListingDto update(String id, MarketListingRequestDto requestDto);

    void deleteById(String id);
}
