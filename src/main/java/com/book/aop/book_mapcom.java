package com.book.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.entity.Book;
import com.book.entity.Book_map;
import com.book.service.Book_mapService;
@Component
@Aspect
public class book_mapcom {
	@Autowired
	private Book_mapService book_mapService;
	@Pointcut("execution(* com.book.service.BookService.insert(com.book.entity.Book_map)) && args(bookmap)")
	public void insert(Book_map bookmap){}
	@After("insert(bookmap)")
	public void insertbook_map(Book_map bookmap){
		book_mapService.insert(bookmap);
	}
}
