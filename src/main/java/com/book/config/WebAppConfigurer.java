package com.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.book.Interceptor.LoginHandlerInterceptor;
@Component
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		super.addInterceptors(registry);
		LoginHandlerInterceptor loginInterceptor1 = new LoginHandlerInterceptor();
        //registry.addInterceptor(loginInterceptor1).addPathPatterns("/admin/Column/*");
        //registry.addInterceptor(loginInterceptor1).addPathPatterns("/admin/Book/*");
        //registry.addInterceptor(loginInterceptor1).addPathPatterns("/admin/CateGory/*");
        //registry.addInterceptor(loginInterceptor1).addPathPatterns("/admin/User/*");
	}
}
