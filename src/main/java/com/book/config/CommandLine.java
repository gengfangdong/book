package com.book.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(value=2)
@Component
public class CommandLine implements CommandLineRunner{
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Spring Boot Start!");
	}

}
