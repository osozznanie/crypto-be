package com.example.geographyservice.mapper;

import com.example.geographyservice.dto.request.ContinentRequestDto;
import com.example.geographyservice.dto.response.ContinentDto;
import com.example.geographyservice.model.Continent;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {
    public ContinentDto toDto(Continent continent) {
        ContinentDto dto = new ContinentDto();
        dto.setId(continent.getId());
        dto.setName(continent.getName());
        dto.setPixelNumber(continent.getPixelNumber());
        dto.setSoldPixelNumber(continent.getSoldPixelNumber());
        return dto;
    }

    public void updateModelFromDto(Continent continent, ContinentRequestDto dto) {
        continent.setName(dto.getName());
        continent.setPixelNumber(dto.getPixelNumber());
    }

    public Continent toModel(ContinentRequestDto dto) {
        Continent continent = new Continent();
        continent.setName(dto.getName());
        continent.setPixelNumber(dto.getPixelNumber());
        return continent;
    }
}
