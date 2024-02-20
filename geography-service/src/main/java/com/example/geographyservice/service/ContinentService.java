package com.example.geographyservice.service;

import com.example.geographyservice.dto.request.ContinentRequestDto;
import com.example.geographyservice.dto.response.ContinentDto;
import java.util.List;

public interface ContinentService {
    ContinentDto save(ContinentRequestDto requestDto);

    ContinentDto getById(String id);

    List<ContinentDto> getAll();

    ContinentDto update(String id, ContinentRequestDto requestDto);

    void deleteById(String id);
}
