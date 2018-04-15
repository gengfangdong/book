package com.book.service;

import java.util.List;

import com.book.entity.Book_map;;

public interface Book_mapService {
	public void insert(Book_map book_map);
	public Book_map getbyid(int id);
	public List<Book_map> getall();
	public void delete(int id);
	public void delet(String filename);
	public Book_map getbyname(String filename);
}
