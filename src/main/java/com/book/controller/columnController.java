package com.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.Book_column;
import com.book.entity.Columnlist;
import com.book.service.CateGoryService;
import com.book.service.ColumnService;


@RestController
@RequestMapping("admin/Column")
public class columnController {
	@Autowired
	private CateGoryService categoryService;
	@Autowired
	private ColumnService columnService;
	@RequestMapping("/add")
	public ModelAndView add(Model model,ModelAndView mv){
		mv.setViewName("admin/column/add");
		model.addAttribute("cateGorylist", categoryService.selectAllCategory());
		model.addAttribute("entity", new Book_column());
		return mv;
	}
	@RequestMapping("/save")
	public void save(Book_column book_column,ModelAndView mv,HttpServletResponse response){
		columnService.add_column(book_column);
		System.out.println(book_column);
		try {
			response.sendRedirect("/book/admin/Column/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@RequestMapping("/list")
	public ModelAndView getall(Model model,ModelAndView mv,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=8;
		int from=(pageNO-1)*size;
		List<Columnlist> list=new ArrayList<Columnlist>();
		Columnlist columnlist;
		for(Book_column column:columnService.getlistpager(from,size)){
			columnlist=new Columnlist(categoryService.getbyid(column.getCate_id()), column);
			list.add(columnlist);
		}
		System.out.println(columnService.getallcoulumn().size()+1);
		model.addAttribute("count", columnService.getallcoulumn().size());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("column_list", list);
		mv.setViewName("admin/column/list");
		return mv;
	}
	@RequestMapping("delete/{id}")
	public void delete(@PathVariable int id,HttpServletResponse response){
		columnService.delete(id);
		try {
			response.sendRedirect("/book/admin/Column/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("edit/{id}")
	public ModelAndView edit(@PathVariable int id,ModelAndView mv,Model model){
		model.addAttribute("entity", columnService.getbyid(id));
		model.addAttribute("cateGorylist", categoryService.selectAllCategory());
		mv.setViewName("admin/column/edit");
		return mv;
	}
	@RequestMapping("update")
	public void update(HttpServletResponse response,Book_column column){
		columnService.update(column);
		try {
			response.sendRedirect("/book/admin/Column/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deletes")
	public void deletes(@RequestParam("id")int[] ids,HttpServletResponse response,Model model){
		
		columnService.deletes(ids);
		try {
			response.sendRedirect("/book/admin/Column/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/getcolumn")
	public ModelAndView getcolumnlist(@RequestParam("id")int id,Model model,ModelAndView mv,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=4;
		int from=(pageNO-1)*size;
		List<Book_column> list=new ArrayList<Book_column>();
		list=columnService.getbycate_id(id, from, size);
		model.addAttribute("count", columnService.getbyCate_id(id).size());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("column_list", list);
		model.addAttribute("id", id);
		model.addAttribute("cate_name", categoryService.getbyid(list.get(0).getCate_id()).getCate_name());
		mv.setViewName("sort");
		return mv;	
	}
}
