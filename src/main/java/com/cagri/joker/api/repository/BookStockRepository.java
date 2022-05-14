package com.cagri.joker.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cagri.joker.api.model.BookStock;

public interface BookStockRepository extends MongoRepository<BookStock, String> {
	
	public BookStock findByBookNameIgnoreCase(String bookName);

}
