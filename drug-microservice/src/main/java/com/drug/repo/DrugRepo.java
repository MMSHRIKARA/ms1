package com.drug.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.drug.entity.Drug;

public interface DrugRepo extends MongoRepository<Drug, Integer> {
//	@Query("{username:?0}")
//	Drug findByUsername(String username);

}