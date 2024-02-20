package com.example.transactionservice.repository;

import com.example.transactionservice.model.PixelTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PixelTransactionRepository extends MongoRepository<PixelTransaction, String> {
}
