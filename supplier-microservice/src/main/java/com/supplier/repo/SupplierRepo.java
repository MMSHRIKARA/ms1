package com.supplier.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.supplier.entity.Supplier;

public interface SupplierRepo extends MongoRepository<Supplier, Long>{

}
