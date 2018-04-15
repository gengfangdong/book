package com.book.entity;

import java.io.Serializable;

public class Book_column implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Column_id;
	private String Column_name;
	private String Column_desc;
	private Integer Cate_id;
	
	


	


	public Book_column() {
		super();
	}

	

	public Book_column(String column_name, String column_desc, Integer cate_id) {
		super();
		Column_name = column_name;
		Column_desc = column_desc;
		Cate_id = cate_id;
	}



	public Integer getColumn_id() {
		return Column_id;
	}

	public void setColumn_id(Integer column_id) {
		Column_id = column_id;
	}

	public String getColumn_name() {
		return Column_name;
	}

	public void setColumn_name(String column_name) {
		Column_name = column_name;
	}

	public String getColumn_desc() {
		return Column_desc;
	}

	public void setColumn_desc(String column_desc) {
		Column_desc = column_desc;
	}

	public Integer getCate_id() {
		return Cate_id;
	}

	public void setCate_id(Integer cate_id) {
		Cate_id = cate_id;
	}

	@Override
	public String toString() {
		return "Book_column [Column_id=" + Column_id + ", Column_name=" + Column_name + ", Column_desc=" + Column_desc
				+ ", Cate_id=" + Cate_id + "]";
	}

	
	 
}
