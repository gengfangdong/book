package com.book.entity;

import java.io.Serializable;

public class BookAlllist implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private Book_map book_map;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Book_map getBook_map() {
		return book_map;
	}
	public void setBook_map(Book_map book_map) {
		this.book_map = book_map;
	}
	public BookAlllist() {
		super();
	}
	
	public BookAlllist(Book book, Book_map book_map) {
		super();
		this.book = book;
		this.book_map = book_map;
	}
	@Override
	public String toString() {
		return "BookAlllist [book=" + book + ", book_map=" + book_map + "]";
	}
	
}
