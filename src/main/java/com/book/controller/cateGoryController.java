package com.book.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.CateGory;
import com.book.service.CateGoryService;


@RestController
@RequestMapping("admin/Category")
public class cateGoryController {
	@Autowired
	private CateGoryService cateGoryService;
	@RequestMapping("/list")
	public ModelAndView admin(ModelAndView mv,Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
		int size=8;
		int from=(pageNO-1)*size;
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("count", cateGoryService.getcount());
		model.addAttribute("cateGorylist", cateGoryService.getlistpager(from, size));
		mv.setViewName("admin/category/list");
		return mv;
	}
	@RequestMapping(value="/add")
	public ModelAndView addCate(Model model,ModelAndView mv){
		model.addAttribute("entity", new CateGory());
		mv.setViewName("admin/category/add");
		return mv;
	}
	@RequestMapping(value="/save")
	public ModelAndView saveCate(CateGory cateGory,ModelAndView mv,Model model,HttpServletResponse response){
		System.out.println(cateGory);
		cateGoryService.Cate_add(cateGory);
		model.addAttribute("cateGorylist", cateGoryService.selectAllCategory());
		try {
			response.sendRedirect("/book/admin/Category/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("/delete/{cate_id}")
	public void delete(@PathVariable int cate_id,Model model,ModelAndView mv,HttpServletResponse httpServletResponse){
		cateGoryService.delete(cate_id);
		model.addAttribute("cateGorylist", cateGoryService.selectAllCategory());
		try {
			httpServletResponse.sendRedirect("/book/admin/Category/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id,ModelAndView mv,Model model){
		model.addAttribute("entity", cateGoryService.getbyid(id));
		mv.setViewName("admin/category/edit");
		return mv;
	}
	@RequestMapping("/updat")
	public void update(CateGory cateGory,HttpServletResponse response){
		cateGoryService.update(cateGory);
		try {
			response.sendRedirect("/book/admin/Category/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deletes")
	public void deletes(@RequestParam("id")int[] ids,HttpServletResponse response,Model model){
		
		cateGoryService.deletes(ids);
		try {
			response.sendRedirect("/book/admin/Category/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
