package com.example.geographyservice.service.impl;

import com.example.geographyservice.model.World;
import com.example.geographyservice.repository.WorldRepository;
import com.example.geographyservice.service.WorldService;
import jakarta.annotation.PostConstruct;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorldServiceImpl implements WorldService {
    private static final String WORLD_ID = "crypto-world";
    private final WorldRepository worldRepository;
    private World world;

    @PostConstruct
    public void loadWorldData() {
        Optional<World> worldOptional = worldRepository.findById(WORLD_ID);
        if (worldOptional.isPresent()) {
            world = worldOptional.get();
        } else {
            world = new World();
            worldRepository.save(world);
        }
    }

    @Override
    public Long getTotalPixelNumber() {
        return world.getTotalPixelNumber();
    }

    @Override
    public Long getTotalSoldPixelNumber() {
        return world.getSoldPixelNumber();
    }

    @Override
    public void addSoldPixels(Long soldPixelNumber) {
        world.setSoldPixelNumber(world.getSoldPixelNumber() + soldPixelNumber);
        worldRepository.save(world);
    }
}
