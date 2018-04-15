package com.book.service;

import java.util.List;

import com.book.entity.Book;
import com.book.entity.Book_map;


public interface BookService {
	public void insert(Book book);
	public List<Book> getlistpager(int from,int to);
	public List<Book> getall();
	public void update(Book book);
	public void delete(int id);
	public Book getbyid(int id);
	public void deletefile(String filename);
	public void insert(Book_map book_map);
	public Book getbyname(String filename);
	public void deleteimage(String filename);
	public List<Book> getbycolumn_id(int id,int from,int to);
	public List<Book> getbycolumn_id(int id);

}
