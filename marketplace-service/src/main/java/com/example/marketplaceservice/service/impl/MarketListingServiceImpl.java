package com.example.marketplaceservice.service.impl;

import com.example.marketplaceservice.dto.request.MarketListingRequestDto;
import com.example.marketplaceservice.dto.response.MarketListingDto;
import com.example.marketplaceservice.mapper.MarketListingMapper;
import com.example.marketplaceservice.model.MarketListing;
import com.example.marketplaceservice.repository.MarketListingRepository;
import com.example.marketplaceservice.service.MarketListingService;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketListingServiceImpl implements MarketListingService {
    private final MarketListingRepository marketListingRepository;
    private final MarketListingMapper marketListingMapper;

    @Override
    public MarketListingDto save(MarketListingRequestDto requestDto) {
        MarketListing marketListing = marketListingMapper.toModel(requestDto);
        marketListing.setPublishDate(LocalDateTime.now());
        return marketListingMapper.toDto(marketListingRepository.save(marketListing));
    }

    @Override
    public MarketListingDto getById(String id) {
        return marketListingMapper.toDto(marketListingRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No market listing is found by id = " + id)
        ));
    }

    @Override
    public List<MarketListingDto> getALl() {
        return marketListingRepository.findAll().stream()
                .map(marketListingMapper::toDto)
                .toList();
    }

    @Override
    public MarketListingDto update(String id, MarketListingRequestDto requestDto) {
        MarketListing marketListingForUpdate = marketListingRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No market listing is found by id = " + id)
        );
        marketListingMapper.updateModelFromDto(marketListingForUpdate, requestDto);
        marketListingRepository.save(marketListingForUpdate);
        return marketListingMapper.toDto(marketListingForUpdate);
    }

    @Override
    public void deleteById(String id) {
        marketListingRepository.deleteById(id);
    }
}
