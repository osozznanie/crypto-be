package com.example.transactionservice.service.impl;

import com.example.transactionservice.dto.request.PixelTransactionRequestDto;
import com.example.transactionservice.dto.response.PixelTransactionDto;
import com.example.transactionservice.mapper.PixelTransactionMapper;
import com.example.transactionservice.model.PixelTransaction;
import com.example.transactionservice.repository.PixelTransactionRepository;
import com.example.transactionservice.service.PixelTransactionService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixelTransactionServiceImpl implements PixelTransactionService {
    private final PixelTransactionRepository pixelTransactionRepository;
    private final PixelTransactionMapper pixelTransactionMapper;

    @Override
    public PixelTransactionDto save(PixelTransactionRequestDto requestDto) {
        PixelTransaction pixelTransaction = pixelTransactionMapper.toModel(requestDto);
        return pixelTransactionMapper.toDto(pixelTransactionRepository.save(pixelTransaction));
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
