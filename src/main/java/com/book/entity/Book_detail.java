package com.book.entity;

public class Book_detail {
	private Book book;
	private Book_column column;
	private CateGory category;
	
	public Book_detail(Book book, Book_column column, CateGory category) {
		super();
		this.book = book;
		this.column = column;
		this.category = category;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Book_column getColumn() {
		return column;
	}
	public void setColumn(Book_column column) {
		this.column = column;
	}
	public CateGory getCategory() {
		return category;
	}
	public void setCategory(CateGory category) {
		this.category = category;
	}
	
}
