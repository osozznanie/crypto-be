package com.example.geographyservice.repository;

import com.example.geographyservice.model.Pixel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PixelRepository extends MongoRepository<Pixel, String> {
}
