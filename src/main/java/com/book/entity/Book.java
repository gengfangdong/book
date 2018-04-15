package com.book.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Book_id;
	private String Book_name;
	private String Book_desc;
	private String Book_user;
	private Timestamp Book_data;
	private String Book_file;
	private Integer column_id;
	private Integer Cate_id;
	public Book() {
		super();
	}

	
	

	public Book(String book_name, String book_desc, String book_user, Timestamp book_data, String book_file,
			Integer column_id, Integer cate_id) {
		super();
		Book_name = book_name;
		Book_desc = book_desc;
		Book_user = book_user;
		Book_data = book_data;
		Book_file = book_file;
		this.column_id = column_id;
		Cate_id = cate_id;
	}




	public Integer getBook_id() {
		return Book_id;
	}

	public void setBook_id(Integer book_id) {
		Book_id = book_id;
	}

	public String getBook_name() {
		return Book_name;
	}

	public void setBook_name(String book_name) {
		Book_name = book_name;
	}

	public String getBook_desc() {
		return Book_desc;
	}

	public void setBook_desc(String book_desc) {
		Book_desc = book_desc;
	}

	public String getBook_user() {
		return Book_user;
	}

	public void setBook_user(String book_user) {
		Book_user = book_user;
	}

	public Timestamp getBook_data() {
		return Book_data;
	}

	public void setBook_data(Timestamp book_data) {
		Book_data = book_data;
	}

	public Integer getColumn_id() {
		return column_id;
	}

	public void setColumn_id(Integer column_id) {
		this.column_id = column_id;
	}

	public Integer getCate_id() {
		return Cate_id;
	}


	public void setCate_id(Integer cate_id) {
		Cate_id = cate_id;
	}


	public String getBook_file() {
		return Book_file;
	}




	public void setBook_file(String book_file) {
		Book_file = book_file;
	}




	@Override
	public String toString() {
		return "Book [Book_id=" + Book_id + ", Book_name=" + Book_name + ", Book_desc=" + Book_desc + ", Book_user="
				+ Book_user + ", Book_data=" + Book_data + ", Book_file=" + Book_file + ", column_id=" + column_id
				+ ", Cate_id=" + Cate_id + "]";
	}


	
	
}
