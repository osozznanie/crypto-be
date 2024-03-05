package com.example.transactionservice.controller;

import com.example.transactionservice.dto.request.PixelTransactionRequestDto;
import com.example.transactionservice.dto.response.PixelTransactionDto;
import com.example.transactionservice.service.PixelTransactionService;
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
@RequestMapping("/api/pixel-transactions")
@RequiredArgsConstructor
public class PixelTransactionController {
    private final PixelTransactionService pixelTransactionService;

    @PostMapping
    public PixelTransactionDto addPixelTransaction(@RequestBody @Valid PixelTransactionRequestDto requestDto) {
        return pixelTransactionService.save(requestDto);
    }

    @PostMapping("/country-pixel-purchase")
    public PixelTransactionDto addPixelPurchase(@RequestBody @Valid PixelTransactionRequestDto requestDto) {
        return pixelTransactionService.createPurchase(requestDto);
    }

    @GetMapping("/{id}")
    public PixelTransactionDto getPixelTransactionById(@PathVariable String id) {
        return pixelTransactionService.getById(id);
    }

    @GetMapping
    public List<PixelTransactionDto> getPixelTransactions() {
        return pixelTransactionService.getAll();
    }

    @PutMapping("/{id}")
    public PixelTransactionDto updatePixelTransaction(@PathVariable String id,
                                    @RequestBody @Valid PixelTransactionRequestDto requestDto) {
        return pixelTransactionService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deletePixelTransaction(@PathVariable String id) {
        pixelTransactionService.deleteById(id);
        return "Pixel transaction with id = " + id + " is successfully removed";
    }
}
