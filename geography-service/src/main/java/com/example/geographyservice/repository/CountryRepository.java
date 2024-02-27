package com.example.geographyservice.repository;

import com.example.geographyservice.model.Country;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {
    Optional<Country> findByTag(String tag);
}
