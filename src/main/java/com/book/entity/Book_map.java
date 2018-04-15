package com.book.entity;

import java.io.Serializable;

public class Book_map implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String book_util;
	private String book_file;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBook_util() {
		return book_util;
	}
	public void setBook_util(String book_util) {
		this.book_util = book_util;
	}
	public String getBook_file() {
		return book_file;
	}
	public void setBook_file(String book_file) {
		this.book_file = book_file;
	}
	
	public Book_map() {
		super();
	}
	public Book_map(String book_util, String book_file) {
		super();
		this.book_util = book_util;
		this.book_file = book_file;
	}
	@Override
	public String toString() {
		return "Book_map [id=" + id + ", book_util=" + book_util + ", book_file=" + book_file + "]";
	}
	
	
}
