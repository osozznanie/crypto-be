package com.example.geographyservice.repository;

import com.example.geographyservice.model.Continent;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ContinentRepository extends MongoRepository<Continent, String> {
}

