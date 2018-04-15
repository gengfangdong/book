package com.book.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.book.service.BookService;
import com.book.service.CateGoryService;
import com.book.service.ColumnService;
import com.book.util.TimerGetlist;

@Component
@WebListener
public class StartListener implements ServletContextListener {
	@Autowired
	private BookService bookService;
	@Autowired
	private ColumnService columnService;
	@Autowired
	private CateGoryService cateGoryService;
	@Autowired
	private TimerGetlist timerGetlist;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent se) {
		// TODO Auto-generated method stub
		WebApplicationContextUtils.getRequiredWebApplicationContext(se.getServletContext())  
        .getAutowireCapableBeanFactory().autowireBean(this);  
		timerGetlist.setApplication(se.getServletContext());
		se.getServletContext().setAttribute("booklist", bookService.getlistpager(0, 8));
		se.getServletContext().setAttribute("categorylist", cateGoryService.selectAllCategory());
		se.getServletContext().setAttribute("columnlist", columnService.getlistpager(0, 4));
		System.out.println("The Start is Over!");
	}

}
