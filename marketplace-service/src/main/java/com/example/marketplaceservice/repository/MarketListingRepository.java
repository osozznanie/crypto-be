package com.example.marketplaceservice.repository;

import com.example.marketplaceservice.model.MarketListing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketListingRepository extends MongoRepository<MarketListing, String> {
}
