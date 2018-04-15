package com.book.entity;

public class Columnlist {
	private CateGory cateGory;
	private Book_column column;
	
	public Columnlist() {
		super();
	}
	public CateGory getCateGory() {
		return cateGory;
	}
	public void setCateGory(CateGory cateGory) {
		this.cateGory = cateGory;
	}
	public Book_column getColumn() {
		return column;
	}
	public void setColumn(Book_column column) {
		this.column = column;
	}
	public Columnlist(CateGory cateGory, Book_column column) {
		super();
		this.cateGory = cateGory;
		this.column = column;
	}
	@Override
	public String toString() {
		return "Columnlist [cateGory=" + cateGory + ", column=" + column + "]";
	}
	
}
