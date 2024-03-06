package com.example.marketplaceservice.service.impl;

import com.example.marketplaceservice.dto.request.MarketListingRequestDto;
import com.example.marketplaceservice.dto.response.MarketListingDto;
import com.example.marketplaceservice.dto.response.PixelDto;
import com.example.marketplaceservice.dto.response.UserDto;
import com.example.marketplaceservice.feigns.PixelFeign;
import com.example.marketplaceservice.feigns.UserFeign;
import com.example.marketplaceservice.mapper.MarketListingMapper;
import com.example.marketplaceservice.model.MarketListing;
import com.example.marketplaceservice.repository.MarketListingRepository;
import com.example.marketplaceservice.service.MarketListingService;
import com.sun.jdi.request.InvalidRequestStateException;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MarketListingServiceImpl implements MarketListingService {
    private final MarketListingRepository marketListingRepository;
    private final MarketListingMapper marketListingMapper;
    private final PixelFeign pixelFeign;
    private final UserFeign userFeign;

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

    @Override
    @Transactional
    public MarketListingDto createMarketListing(MarketListingRequestDto requestDto) {
        UserDto userDto = userFeign.getUserByEmail(requestDto.getUserEmail());

        if (userDto.getPixelNumber() < requestDto.getPixelIds().size()) {
            throw new InvalidRequestStateException("The company doesn't have enough pixels to list for sale");
        }

        MarketListingDto marketListingDto = save(requestDto);

        List<PixelDto> pixelDtos = pixelFeign.getAllPixelsByIds(requestDto.getPixelIds());

        pixelDtos.forEach(
                pixelDto -> pixelDto.setMarketListingId(marketListingDto.getId())
        );

        pixelFeign.saveAllPixels(pixelDtos);

        return marketListingDto;
    }
}
