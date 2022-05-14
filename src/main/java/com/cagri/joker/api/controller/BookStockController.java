package com.cagri.joker.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cagri.joker.api.dto.ApiOutput;
import com.cagri.joker.api.dto.ApiStatusOutput;
import com.cagri.joker.api.dto.BookStockInfoInput;
import com.cagri.joker.api.dto.BookStockInfoOutput;
import com.cagri.joker.api.service.BookStockService;

@RestController
@RequestMapping("/api/bookstock")
public class BookStockController {
	
	@Autowired
	private BookStockService bookStockService;
	
	@PostMapping(path = "/addBookStockOperations")
	public ApiOutput<BookStockInfoOutput> addBookStockOperations(@Valid @RequestBody BookStockInfoInput input) {
		BookStockInfoOutput output = bookStockService.addBookStockOperations(input);
		return new ApiOutput<BookStockInfoOutput>(ApiStatusOutput.SUCCESS, output);
	}

}
