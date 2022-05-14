package com.cagri.joker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cagri.joker.api.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	public Customer findByEmailIgnoreCase(String email);

}
