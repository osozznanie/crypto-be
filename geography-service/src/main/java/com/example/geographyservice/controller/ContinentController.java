package com.example.geographyservice.controller;

import com.example.geographyservice.dto.request.ContinentRequestDto;
import com.example.geographyservice.dto.response.ContinentDto;
import com.example.geographyservice.service.ContinentService;
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
@RequestMapping("/api/continents")
@RequiredArgsConstructor
public class ContinentController {
    private final ContinentService continentService;

    @PostMapping
    public ContinentDto addContinent(@RequestBody @Valid ContinentRequestDto requestDto) {
        return continentService.save(requestDto);
    }

    @GetMapping("/{id}")
    public ContinentDto getContinentById(@PathVariable String id) {
        return continentService.getById(id);
    }
    @GetMapping
    public List<ContinentDto> getAllContinents() {
        return continentService.getAll();
    }

    @PutMapping("/{id}")
    public ContinentDto updateContinent(@PathVariable String id,
                                        @RequestBody @Valid ContinentRequestDto requestDto) {
        return continentService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteContinent(@PathVariable String id) {
        continentService.deleteById(id);
        return "Continent with id = " + id + " is successfully removed";
    }
}
