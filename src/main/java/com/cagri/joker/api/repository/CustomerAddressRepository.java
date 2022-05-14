package com.cagri.joker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cagri.joker.api.model.CustomerAddress;

public interface CustomerAddressRepository extends MongoRepository<CustomerAddress, String>{

}
