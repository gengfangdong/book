package com.book.aop;


import java.io.File;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.service.BookService;
import com.book.service.Book_mapService;
import com.book.util.Filedelete;
import com.book.util.Fileupdate;

@Component
@Aspect
public class deleteFile {
	@Autowired
	private Filedelete filedelete;
	@Autowired
	private Fileupdate fileload;
	@Pointcut("execution(* com.book.service.BookService.deletefile(String)) && args(filename)")
	public void delet(String filename){}
	@After("delet(filename)")
	public void deletefile(String filename){
		fileload.delete(filename);
		File tempFile =new File(filename);    
        String fileName = tempFile.getName();      
        System.out.println("fileName = " + fileName); 
		try {
			filedelete.delete(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
