package com.example.geographyservice.repository;

import com.example.geographyservice.model.Pixel;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PixelRepository extends MongoRepository<Pixel, String> {
    @Query("{ 'id' : { $regex: ?0, $options: 'i' } }")
    List<Pixel> findAllByCountryTag(String tag);

    List<Pixel> findAllByCompanyId(String companyId);
}
