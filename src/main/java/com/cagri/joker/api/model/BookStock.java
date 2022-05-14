package com.cagri.joker.api.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "BOOK_STOCK")
public class BookStock implements Serializable{

	private static final long serialVersionUID = -3360067050082565078L;

	@Id
	private String id;

	@Field("book_name")
	private String bookName;

	@Field("book_author")
	private String author;

	@Field("publish_house")
	private String publishHouse;

	@CreatedDate
	@Field("publish_date")
	private Date publishDate;

	@LastModifiedDate
	@Field("last_modified_stock_date")
	private Date lastModifiedStockDate;

	/**
	 * will get from another external service for exam
	 */
	@Field("book_isbn")
	private String bookISBN;

	@Field("price")
	private Integer price;

	@Field("stock_count")
	private Integer stockCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishHouse() {
		return publishHouse;
	}

	public void setPublishHouse(String publishHouse) {
		this.publishHouse = publishHouse;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getLastModifiedStockDate() {
		return lastModifiedStockDate;
	}

	public void setLastModifiedStockDate(Date lastModifiedStockDate) {
		this.lastModifiedStockDate = lastModifiedStockDate;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

}
