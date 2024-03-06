package com.example.transactionservice.service.impl;

import com.example.transactionservice.dto.request.CompanyRequestDto;
import com.example.transactionservice.dto.request.CountryPurchaseRequestDto;
import com.example.transactionservice.dto.request.PixelTransactionRequestDto;
import com.example.transactionservice.dto.request.PixelTransactionWithoutCompanyIdRequestDto;
import com.example.transactionservice.dto.request.UserUpdateRequestDto;
import com.example.transactionservice.dto.response.CompanyDto;
import com.example.transactionservice.dto.response.CountryDto;
import com.example.transactionservice.dto.response.PixelTransactionDto;
import com.example.transactionservice.dto.response.UserDto;
import com.example.transactionservice.exception.InvalidTransactionException;
import com.example.transactionservice.feigns.CompanyFeign;
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
    private final CompanyFeign companyFeign;
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
    public PixelTransactionDto createPurchase(PixelTransactionWithoutCompanyIdRequestDto requestDto) {
        CompanyRequestDto senderCompanyRequestDto = new CompanyRequestDto(
                requestDto.getUserEmail(), requestDto.getCompanyName(),
                requestDto.getLogoLink(), requestDto.getWebsiteLink(),
                requestDto.getDescription()
        );
        CompanyDto senderCompanyDto = companyFeign.addCompany(senderCompanyRequestDto);

        PixelTransactionRequestDto dto = new PixelTransactionRequestDto();
        dto.setSenderCompanyId("test-id");
        dto.setSenderUserEmail(requestDto.getUserEmail());
        dto.setReceiverUserEmail("cryptoworld@gmail.com");
        dto.setReceiverCompanyId("ID-Crypto-World");
        dto.setCountryTag(requestDto.getCountryTag());
        dto.setCurrency(requestDto.getCurrency());
        dto.setPrice(requestDto.getPrice());
        dto.setPixelNumber(requestDto.getPixelNumber());

        CountryDto countryDto = countryFeign.getCountryByTag(dto.getCountryTag());

        UserDto userDto = userFeign.getUserByEmail(requestDto.getUserEmail());
        userDto.setPixelNumber(userDto.getPixelNumber() + dto.getPixelNumber());
        userFeign.updateUserPixelNumber(new UserUpdateRequestDto(userDto.getEmail(), userDto.getPixelNumber()));

        Long countrySoldPixelNumber = countryDto.getSoldPixelNumber();
        Long countryRemainedPixelNumber = countryDto.getPixelNumber() - countrySoldPixelNumber;
        if (countryRemainedPixelNumber < dto.getPixelNumber()) {
            throw new InvalidTransactionException("The remained country pixels number is less than the set amount");
        } else if (countryRemainedPixelNumber.equals(dto.getPixelNumber())) {
            dto.setTransactionType("Full Country");
        } else {
            dto.setTransactionType("Pixels");
        }
        countryDto.setSoldPixelNumber(countrySoldPixelNumber + dto.getPixelNumber());
        countryFeign.updateCountryForPurchase(dto.getCountryTag(),
                new CountryPurchaseRequestDto(countryDto.getContinentId(),
                        dto.getSenderCompanyId(), dto.getSenderUserEmail(), dto.getPixelNumber()));

        dto.setTransactionId(requestDto.getTransactionId());
        return save(dto);
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
