package com.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.entity.Order;

public interface OrderRepo extends MongoRepository<Order, Integer>{
	

}
