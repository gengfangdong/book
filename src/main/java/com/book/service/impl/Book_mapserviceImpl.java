package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.book.dao.Book_mapDao;
import com.book.entity.Book_map;
import com.book.service.Book_mapService;
@Service
public class Book_mapserviceImpl implements Book_mapService{
	@Autowired
	private Book_mapDao book_mapDao;
	@Override
	public void insert(Book_map book_map) {
		// TODO Auto-generated method stub
		book_mapDao.insert(book_map);
	}

	@Override
	public Book_map getbyid(int id) {
		// TODO Auto-generated method stub
		return book_mapDao.getbyid(id);
	}

	@Override
	public List<Book_map> getall() {
		// TODO Auto-generated method stub
		return book_mapDao.getall();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		book_mapDao.delete(id);
	}

	@Override
	public void delet(String filename) {
		// TODO Auto-generated method stub
		book_mapDao.delet(filename);
	}

	@Override
	public Book_map getbyname(String filename) {
		// TODO Auto-generated method stub
		return book_mapDao.getbyname(filename);
	}
}
