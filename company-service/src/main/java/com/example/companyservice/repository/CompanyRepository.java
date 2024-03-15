package com.example.companyservice.repository;

import com.example.companyservice.dto.response.CompanyContinentStatistics;
import com.example.companyservice.model.Company;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company, String> {

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'countries', localField: '_id', foreignField: '_id', as: 'country' } }",
            "{ $unwind: '$country' }",
            "{ $lookup: { from: 'continents', localField: 'country.continentId', foreignField: '_id', as: 'continent' } }",
            "{ $unwind: '$continent' }",
            "{ $lookup: { from: 'companies', localField: 'companyId', foreignField: '_id', as: 'company' } }",
            "{ $unwind: '$company' }",
            "{ $group: { _id: { companyName: '$company.name', continentName: '$continent.name' }, purchasedPixels: { $sum: '$country.soldPixelNumber' } } }",
            "{ $sort: { purchasedPixels: -1 } }",
            "{ $group: { _id: '$_id.continentName', topCompany: { $first: '$$ROOT' } } }",
            "{ $replaceRoot: { newRoot: '$topCompany' } }"
    })
    List<CompanyContinentStatistics> findTopCompaniesByContinent();
}

