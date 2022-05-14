package com.cagri.joker.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cagri.joker.api.dto.BookStockInfoInput;
import com.cagri.joker.api.dto.BookStockInfoOutput;
import com.cagri.joker.api.exceptions.BusinessException;
import com.cagri.joker.api.integrations.ISBNClientRequest;
import com.cagri.joker.api.integrations.ISBNClientResponse;
import com.cagri.joker.api.integrations.ISBNService;
import com.cagri.joker.api.model.BookStock;
import com.cagri.joker.api.repository.BookStockRepository;

@Service
public class BookStockServiceImpl implements BookStockService{
	
	@Autowired
	private BookStockRepository bookStockRepository;
	
	@Autowired
	private ISBNService isbnService;

	@Override
	public BookStockInfoOutput addBookStockOperations(BookStockInfoInput input) {
		
		if(input.getStockCount() < 1) {
			throw new BusinessException("Please enter valid stock count...");
		}
		
		BookStock bookStock = bookStockRepository.findByBookNameIgnoreCase(input.getBookName());
		
		if(bookStock == null) {
			bookStock = new BookStock();
			bookStock.setAuthor(input.getAuthor());
			bookStock.setBookISBN(getISBNFromExternalService(input.getBookName(), input.getAuthor(), input.getPublishHouse()));
			bookStock.setBookName(input.getBookName());
			bookStock.setLastModifiedStockDate(new Date());
			bookStock.setPrice(input.getPrice());
			bookStock.setPublishDate(input.getPublishDate());
			bookStock.setPublishHouse(input.getPublishHouse());
			bookStock.setStockCount(input.getStockCount());
		} else {
			bookStock.setStockCount(input.getStockCount());
		}
		
		bookStockRepository.save(bookStock);
		
		return prepareBookStockInfoOutput(bookStock);
	}

	private BookStockInfoOutput prepareBookStockInfoOutput(BookStock bookStock) {
		BookStockInfoOutput output = new BookStockInfoOutput();
		output.setAuthor(bookStock.getAuthor());
		output.setBookIsbn(bookStock.getBookISBN());
		output.setBookName(bookStock.getBookName());
		output.setPrice(bookStock.getPrice());
		output.setPublishHouse(bookStock.getPublishHouse());
		output.setStockCount(bookStock.getStockCount());
		return output;
	}

	private String getISBNFromExternalService(String bookName, String author, String publishHouse) {
		
		ISBNClientRequest request = new ISBNClientRequest();
		request.setAuthor(author);
		request.setBookName(bookName);
		request.setPublishHouse(publishHouse);
		
		ISBNClientResponse response = isbnService.getISBNInfoFromExternalService(request);
		
		return response.getIsbn();
	}

}
