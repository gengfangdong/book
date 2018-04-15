package com.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.Book;
import com.book.entity.Book_detail;
import com.book.entity.User;
import com.book.service.UserService;

@RestController
@RequestMapping("/admin")
public class userController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mv,User user,Model model,HttpServletRequest request){
		if(user.getUser_password().equals(userService.login(user.getUser_name()))){
			request.getSession().setAttribute("login", "Login");
			model.addAttribute("user", user.getUser_name());
			mv.setViewName("admin/index");
			
		}
		else{
			request.getSession().setAttribute("login", "NOlogin");
			model.addAttribute("msg", "用户名或密码不正确!");
			mv.setViewName("admin/login");
		}
		return mv;
	}
	@RequestMapping("/User/add")
	public ModelAndView add(ModelAndView mv,Model model){
		model.addAttribute("entity", new User());
		mv.setViewName("admin/User/add");
		return mv;
	}
	@RequestMapping("/User/save")
	public void save(HttpServletResponse response,User user){
		userService.Add(user);
		try {
			response.sendRedirect("/book/admin/User/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/User/delete/{id}")
	public void delet(HttpServletResponse response,@PathVariable int id)
	{
		userService.delete(id);
		try {
			response.sendRedirect("/book/admin/User/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/User/list")
	public ModelAndView getlist(ModelAndView mv,@RequestParam(defaultValue="1",required=false)int pageNO,Model model){
		int size=4;
		int from=(pageNO-1)*size;
		List<User> list=new ArrayList<User>();
		list=userService.getlist(from, size);
		model.addAttribute("count", userService.getall().size());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("user_list", list);
		mv.setViewName("admin/User/list");
		return mv;
	}
}
