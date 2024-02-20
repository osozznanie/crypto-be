package com.example.geographyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GeographyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeographyServiceApplication.class, args);
    }

}
