package com.example.transactionservice.mapper;

import com.example.transactionservice.dto.request.PixelTransactionRequestDto;
import com.example.transactionservice.dto.response.PixelTransactionDto;
import com.example.transactionservice.model.PixelTransaction;
import org.springframework.stereotype.Component;

@Component
public class PixelTransactionMapper {
    public PixelTransactionDto toDto(PixelTransaction pixelTransaction) {
        PixelTransactionDto dto = new PixelTransactionDto();
        dto.setId(pixelTransaction.getId());
        dto.setSenderCompanyId(pixelTransaction.getSenderCompanyId());
        dto.setReceiverCompanyId(pixelTransaction.getReceiverCompanyId());
        dto.setSenderUserEmail(pixelTransaction.getSenderUserEmail());
        dto.setReceiverUserEmail(pixelTransaction.getReceiverUserEmail());
        dto.setCountryTag(pixelTransaction.getCountryTag());
        dto.setCurrency(pixelTransaction.getCurrency());
        dto.setPrice(pixelTransaction.getPrice());
        dto.setPixelNumber(pixelTransaction.getPixelNumber());
        dto.setTransactionType(pixelTransaction.getTransactionType());
        dto.setTransactionDate(pixelTransaction.getTransactionDate());
        dto.setTransactionId(pixelTransaction.getTransactionId());
        return dto;
    }

    public void updateModelFromDto(PixelTransaction pixelTransaction, PixelTransactionRequestDto dto) {
        pixelTransaction.setSenderCompanyId(dto.getSenderCompanyId());
        pixelTransaction.setReceiverCompanyId(dto.getReceiverCompanyId());
        pixelTransaction.setSenderUserEmail(dto.getSenderUserEmail());
        pixelTransaction.setReceiverUserEmail(dto.getReceiverUserEmail());
        pixelTransaction.setCountryTag(dto.getCountryTag());
        pixelTransaction.setCurrency(dto.getCurrency());
        pixelTransaction.setPrice(dto.getPrice());
        pixelTransaction.setPixelNumber(dto.getPixelNumber());
        pixelTransaction.setTransactionType(dto.getTransactionType());
        pixelTransaction.setTransactionId(dto.getTransactionId());
    }

    public PixelTransaction toModel(PixelTransactionRequestDto dto) {
        PixelTransaction pixelTransaction = new PixelTransaction();
        updateModelFromDto(pixelTransaction, dto);
        return pixelTransaction;
    }
}
