package com.example.transactionservice.service.impl;

import com.example.transactionservice.dto.request.CountryPurchaseRequestDto;
import com.example.transactionservice.dto.request.PixelTransactionRequestDto;
import com.example.transactionservice.dto.request.UserUpdateRequestDto;
import com.example.transactionservice.dto.response.CountryDto;
import com.example.transactionservice.dto.response.PixelTransactionDto;
import com.example.transactionservice.dto.response.UserDto;
import com.example.transactionservice.exception.InvalidTransactionException;
import com.example.transactionservice.feigns.CountryFeign;
import com.example.transactionservice.feigns.UserFeign;
import com.example.transactionservice.mapper.PixelTransactionMapper;
import com.example.transactionservice.model.PixelTransaction;
import com.example.transactionservice.repository.PixelTransactionRepository;
import com.example.transactionservice.service.PixelTransactionService;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PixelTransactionServiceImpl implements PixelTransactionService {
    private final PixelTransactionRepository pixelTransactionRepository;
    private final PixelTransactionMapper pixelTransactionMapper;
    private final CountryFeign countryFeign;
    private final UserFeign userFeign;

    @Override
    public PixelTransactionDto save(PixelTransactionRequestDto requestDto) {
        PixelTransaction pixelTransaction = pixelTransactionMapper.toModel(requestDto);
        pixelTransaction.setTransactionDate(LocalDateTime.now());
        return pixelTransactionMapper.toDto(pixelTransactionRepository.save(pixelTransaction));
    }

    @Override
    @Transactional
    public PixelTransactionDto createPurchase(PixelTransactionRequestDto requestDto) {
        requestDto.setReceiverCompanyId("CryptoWorld");
        CountryDto countryDto = countryFeign.getCountryByTag(requestDto.getCountryTag());
        UserDto userDto = userFeign.getUserByEmail(requestDto.getSenderUserEmail());
        userDto.setPixelNumber(userDto.getPixelNumber() + requestDto.getPixelNumber());
        userFeign.updateUserPixelNumber(new UserUpdateRequestDto(userDto.getEmail(), userDto.getPixelNumber()));
        Long countrySoldPixelNumber = countryDto.getSoldPixelNumber();
        Long countryRemainedPixelNumber = countryDto.getPixelNumber() - countrySoldPixelNumber;
        if (countryRemainedPixelNumber < requestDto.getPixelNumber()) {
            throw new InvalidTransactionException("The remained country pixels number is less than the set amount");
        } else if (countryRemainedPixelNumber.equals(requestDto.getPixelNumber())) {
            requestDto.setTransactionType("Full Country");
        } else {
            requestDto.setTransactionType("Pixels");
        }
        countryDto.setSoldPixelNumber(countrySoldPixelNumber + requestDto.getPixelNumber());
        countryFeign.updateCountryForPurchase(requestDto.getCountryTag(),
                new CountryPurchaseRequestDto(countryDto.getContinentId(),
                        requestDto.getSenderCompanyId(), requestDto.getSenderUserEmail(), requestDto.getPixelNumber()));
        return save(requestDto);
    }

    @Override
    public PixelTransactionDto getById(String id) {
        return pixelTransactionMapper.toDto(pixelTransactionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No pixel transaction is found with id = " + id)
        ));
    }

    @Override
    public List<PixelTransactionDto> getAll() {
        return pixelTransactionRepository.findAll().stream()
                .map(pixelTransactionMapper::toDto)
                .toList();
    }

    @Override
    public PixelTransactionDto update(String id, PixelTransactionRequestDto requestDto) {
        PixelTransaction pixelTransactionForUpdate = pixelTransactionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No pixel transaction is found with id = " + id)
        );
        pixelTransactionMapper.updateModelFromDto(pixelTransactionForUpdate, requestDto);
        pixelTransactionRepository.save(pixelTransactionForUpdate);
        return pixelTransactionMapper.toDto(pixelTransactionForUpdate);
    }

    @Override
    public void deleteById(String id) {
        pixelTransactionRepository.deleteById(id);
    }
}
