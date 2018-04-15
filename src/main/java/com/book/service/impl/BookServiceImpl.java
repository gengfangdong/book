package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.BookDao;
import com.book.entity.Book;
import com.book.entity.Book_map;
import com.book.service.BookService;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		bookDao.insert(book);
	}

	@Override
	public List<Book> getlistpager(int from, int to) {
		// TODO Auto-generated method stub
		return bookDao.getlistpager(from, to);
	}

	@Override
	public List<Book> getall() {
		// TODO Auto-generated method stub
		return bookDao.getallBook();
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
	}

	@Override
	public Book getbyid(int id) {
		// TODO Auto-generated method stub
		Book book=bookDao.getbyid(id);
		return book;
	}

	@Override
	public void deletefile(String filename) {
		// TODO Auto-generated method stub
		System.out.println(filename);
	}

	@Override
	public void insert(Book_map book_map) {
		// TODO Auto-generated method stub
	}

	@Override
	public Book getbyname(String filename) {
		// TODO Auto-generated method stub
		return bookDao.getbyfilename(filename);
	}

	@Override
	public void deleteimage(String filename) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getbycolumn_id(int id, int from, int to) {
		// TODO Auto-generated method stub
		return bookDao.getbycolumn_id(id, from, to);
	}

	@Override
	public List<Book> getbycolumn_id(int id) {
		// TODO Auto-generated method stub
		return bookDao.getbycolumn(id);
	}

}
