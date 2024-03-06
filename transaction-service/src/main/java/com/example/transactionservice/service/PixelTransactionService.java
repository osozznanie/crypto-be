package com.example.transactionservice.service;

import com.example.transactionservice.dto.request.PixelTransactionRequestDto;
import com.example.transactionservice.dto.request.PixelTransactionWithoutCompanyIdRequestDto;
import com.example.transactionservice.dto.response.PixelTransactionDto;
import java.util.List;

public interface PixelTransactionService {
    PixelTransactionDto save(PixelTransactionRequestDto requestDto);

    PixelTransactionDto createPurchase(PixelTransactionWithoutCompanyIdRequestDto requestDto);

    PixelTransactionDto getById(String id);

    List<PixelTransactionDto> getAll();

    PixelTransactionDto update(String id, PixelTransactionRequestDto requestDto);

    void deleteById(String id);
}
