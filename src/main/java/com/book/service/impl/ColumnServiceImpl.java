package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.ColumnDao;
import com.book.entity.Book_column;
import com.book.service.ColumnService;


@Service
public class ColumnServiceImpl implements ColumnService {
	@Autowired
	private ColumnDao columnDao;
	@Override
	public void add_column(Book_column book_column) {
		// TODO Auto-generated method stub
		columnDao.add_column(book_column);
	}
	@Override
	public List<Book_column> getallcoulumn() {
		// TODO Auto-generated method stub
		return columnDao.getallcolumn();
	}
	@Override
	public List<Book_column> getlistpager(int from, int to) {
		// TODO Auto-generated method stub
		return columnDao.getlistpager(from, to);
	}
	@Override
	public Book_column getbyid(int id) {
		// TODO Auto-generated method stub
		return columnDao.getbyid(id);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		columnDao.delete(id);
	}
	@Override
	public void update(Book_column column) {
		// TODO Auto-generated method stub
		columnDao.update(column);
	}
	@Override
	public void deletes(int[] ids) {
		// TODO Auto-generated method stub
		for(int id:ids){
			columnDao.delete(id);
		}
	}
	@Override
	public List<Book_column> getbycate_id(int id,int from,int to) {
		// TODO Auto-generated method stub
		return columnDao.getbycate_id(id,from,to);
	}
	@Override
	public List<Book_column> getbyCate_id(int id) {
		// TODO Auto-generated method stub
		return columnDao.getbyCate_id(id);
	}
	
}
