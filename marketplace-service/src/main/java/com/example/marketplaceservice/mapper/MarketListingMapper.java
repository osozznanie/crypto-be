package com.example.marketplaceservice.mapper;

import com.example.marketplaceservice.dto.request.MarketListingRequestDto;
import com.example.marketplaceservice.dto.response.MarketListingDto;
import com.example.marketplaceservice.model.MarketListing;
import org.springframework.stereotype.Component;

@Component
public class MarketListingMapper {
    public MarketListingDto toDto(MarketListing marketListing) {
        MarketListingDto dto = new MarketListingDto();
        dto.setId(marketListing.getId());
        dto.setCompanyId(marketListing.getCompanyId());
        dto.setCountryId(marketListing.getCountryId());
        dto.setCurrency(marketListing.getCurrency());
        dto.setPrice(marketListing.getPrice());
        dto.setPixelNumbers(marketListing.getPixelNumbers());
        dto.setPublishDate(marketListing.getPublishDate());
        return dto;
    }

    public void updateModelFromDto(MarketListing marketListing, MarketListingRequestDto dto) {
        marketListing.setCompanyId(dto.getCompanyId());
        marketListing.setCountryId(dto.getCountryId());
        marketListing.setCurrency(dto.getCurrency());
        marketListing.setPrice(dto.getPrice());
        marketListing.setPixelNumbers(dto.getPixelNumber());
    }

    public MarketListing toModel(MarketListingRequestDto dto) {
        MarketListing marketListing = new MarketListing();
        updateModelFromDto(marketListing, dto);
        return marketListing;
    }
}
