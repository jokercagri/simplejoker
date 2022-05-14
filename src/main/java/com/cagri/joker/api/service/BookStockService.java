package com.cagri.joker.api.service;

import com.cagri.joker.api.dto.BookStockInfoInput;
import com.cagri.joker.api.dto.BookStockInfoOutput;

public interface BookStockService {
	
	public BookStockInfoOutput addBookStockOperations(BookStockInfoInput input);

}
