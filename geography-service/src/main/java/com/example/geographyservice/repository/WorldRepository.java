package com.example.geographyservice.repository;

import com.example.geographyservice.model.World;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorldRepository extends MongoRepository<World, String> {
}
