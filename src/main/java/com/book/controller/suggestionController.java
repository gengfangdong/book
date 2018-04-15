package com.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.book.entity.Suggestion;
import com.book.entity.User;
import com.book.service.SuggestionService;

@RestController
@RequestMapping("admin/Suggestion")
public class suggestionController {
	@Autowired
	private SuggestionService suggestionService;
	@RequestMapping("/add")
	public ModelAndView add(ModelAndView mv,Model model){	
		model.addAttribute("entity", new Suggestion());
		model.addAttribute("addmsg", "请提交反馈!");
		mv.setViewName("suggestion");
		return mv;
	}
	@RequestMapping("/save")
	public ModelAndView save(ModelAndView mv, Model model,Suggestion suggestion){
		suggestionService.add(suggestion);
		model.addAttribute("addmsg", "反馈已经提交!");
		mv.setViewName("suggestion");
		return mv;
	}
	@RequestMapping("/getlistpager")
	public ModelAndView getlist(@RequestParam(required=false,defaultValue="1")int pageNO,@RequestParam(value="flag",required=false)int flag,ModelAndView mv,Model model){
		int size=8;
		int from=(pageNO-1)*size;
		List<Suggestion> list=new ArrayList<Suggestion>();
		list=suggestionService.getallflag(from, size, flag);
		model.addAttribute("count", suggestionService.getall());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("suggestion_list", list);
		if(flag==0){
			mv.setViewName("/admin/Suggestion/listNO");
		}
		else
		{
			mv.setViewName("/admin/Suggestion/listYES");
		}
		return mv;
	}
	@RequestMapping("delete/{id}")
	public ModelAndView delet(@PathVariable int id,ModelAndView mv,HttpServletResponse response,RedirectAttributes rAttributes){	
		suggestionService.delete(id);
		mv.setViewName("redirect:/admin/Suggestion/getlistpager?flag=1");
		return mv;
	}
	@RequestMapping("/update")
	public ModelAndView update(ModelAndView mv,Suggestion suggestion,Model model,HttpServletResponse response,RedirectAttributes rAttributes){
		suggestionService.update(suggestion);
		if(suggestion.getSuggestion_flag()==1){
			mv.setViewName("redirect:/admin/Suggestion/getlistpager?flag=0");
			
		}
		else{
			mv.setViewName("redirect:/admin/Suggestion/getlistpager?flag=1");
		}
		return mv;
	}
	
}
