package com.cagri.joker.api.dto;

public class CreateOrderBookInfoInput {

	private String bookName;
	private int orderCount;
	private int bookPrice;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public int getTotalPriceForABook() {
		return orderCount * bookPrice;
	}

}
