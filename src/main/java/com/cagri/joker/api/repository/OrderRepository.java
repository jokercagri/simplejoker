package com.cagri.joker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cagri.joker.api.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	
	public Order findByCustomerEmailIgnoreCase(String customerEmail);

}
