package com.book.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.User;

@Controller
public class homepageController {
	private Logger log=LoggerFactory.getLogger(homepageController.class);
	@RequestMapping("/index")
	public String home(Map<String,Object> map){ 
	       return "index"; 
	}
	@RequestMapping("/company")
	public ModelAndView company(ModelAndView mv){
		mv.setViewName("company");
		return mv;
	}
	@RequestMapping("/admin")
	public String admin(Model model,HttpServletRequest request){
		request.getSession().setAttribute("login", "NOlogin");
		model.addAttribute("entity", new User());
		model.addAttribute("msg", "请登录！");
		return "/admin/login";
	}
}
