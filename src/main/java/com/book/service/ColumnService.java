package com.book.service;

import java.util.List;

import com.book.entity.Book_column;



public interface ColumnService {
	public void add_column(Book_column book_column);
	public List<Book_column> getallcoulumn();
	public List<Book_column> getlistpager(int from,int to);
	public Book_column getbyid(int id);
	public void delete(int id);
	public void update(Book_column column);
	public void deletes(int[] ids);
	public List<Book_column> getbycate_id(int id,int from,int to);
	public List<Book_column> getbyCate_id(int id);
}
