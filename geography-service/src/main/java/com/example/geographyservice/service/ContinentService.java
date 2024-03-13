package com.example.geographyservice.service;

import com.example.geographyservice.dto.request.ContinentPurchaseRequestDto;
import com.example.geographyservice.dto.request.ContinentRequestDto;
import com.example.geographyservice.dto.response.ContinentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContinentService {
    ContinentDto save(ContinentRequestDto requestDto);

    ContinentDto getById(String id);

    List<ContinentDto> getAll();

    ContinentDto update(String id, ContinentRequestDto requestDto);

    ContinentDto updateForPurchase(String id, ContinentPurchaseRequestDto requestDto);

    void deleteById(String id);
}
