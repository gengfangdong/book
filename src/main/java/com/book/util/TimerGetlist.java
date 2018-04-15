package com.book.util;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.book.service.BookService;
import com.book.service.CateGoryService;
import com.book.service.ColumnService;
@Component
@EnableScheduling
public class TimerGetlist{
	@Autowired
	private BookService bookService;
	@Autowired
	private ColumnService columnService;
	@Autowired
	private CateGoryService cateGoryService;
	private ServletContext application=null;
	
	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Scheduled(cron = "0 0/1 * * * ?")
	public void get() {
		// TODO Auto-generated method stub
		application.setAttribute("booklist", bookService.getlistpager(0, 8));
		application.setAttribute("categorylist", cateGoryService.selectAllCategory());
		application.setAttribute("columnlist", columnService.getlistpager(0, 4));
		System.out.println(" application The Start is Over!");
	}

}
