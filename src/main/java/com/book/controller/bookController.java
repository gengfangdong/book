package com.book.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.book.entity.Book;
import com.book.entity.BookAlllist;
import com.book.entity.Book_column;
import com.book.entity.Book_detail;
import com.book.entity.Book_map;
import com.book.service.BookService;
import com.book.service.Book_mapService;
import com.book.service.CateGoryService;
import com.book.service.ColumnService;
import com.book.util.Filedownload;
import com.book.util.Fileupdate;
import com.book.util.PdfgetImage;
import com.mysql.fabric.xmlrpc.base.Array;

@RestController
@RequestMapping("admin/Book")
public class bookController {
	@Autowired
	private Book_mapService book_mapService;
	@Autowired
	private Filedownload filedownload;
	@Autowired
	private Fileupdate fileupdate;
	@Autowired
	private BookService bookService;
	@Autowired
	private ColumnService columnService;
	@Autowired
	private CateGoryService categoryService;
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(required=false,defaultValue="1")int pageNO,ModelAndView mv,Model model){
		int size=8;
		int from=(pageNO-1)*size;
		List<Book_detail> booklist=new ArrayList<Book_detail>();
		Book_detail bDetail;
		for(Book book:bookService.getlistpager(from, size)){
			bDetail=new Book_detail(book, columnService.getbyid(book.getColumn_id()), categoryService.getbyid(book.getCate_id()));
			booklist.add(bDetail);
		}
		model.addAttribute("count", bookService.getall().size());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("booklist", booklist);
		mv.setViewName("admin/Book/list");
		return mv;
	}
	@RequestMapping("/add")
	public ModelAndView add(Model model,ModelAndView mv){
		model.addAttribute("entity", new Book());
		model.addAttribute("columnlist", columnService.getallcoulumn());
		mv.setViewName("admin/Book/add");
		return mv;
	}
	@RequestMapping("/save")
	public void save(Book book,ModelAndView mv,@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpServletRequest request){
		Book_map book_map;
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String fileFileName=file.getOriginalFilename();
		System.out.println(fileFileName);
		String newsName=fileupdate.uploadFile(file, fileFileName,request.getServletContext().getRealPath("file/"));
		book.setBook_file(newsName);
		book_map=new Book_map(fileFileName, newsName);
		book.setBook_data(Timestamp.valueOf(nowTime));
		book.setCate_id(categoryService.getbyid(columnService.getbyid(book.getColumn_id()).getCate_id()).getCate_id());
		bookService.insert(book);
		bookService.insert(book_map);
		//System.out.println(Timestamp.valueOf(nowTime).getYear()+1900+":"+Timestamp.valueOf(nowTime).getMonth()+1+":"+Timestamp.valueOf(nowTime).getDate());
		try {
			response.sendRedirect("/book/admin/Book/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/delete/{id}")
	public void delete(ModelAndView mv,Model model,HttpServletResponse response,@PathVariable int id,HttpServletRequest request){
		bookService.deletefile(request.getServletContext().getRealPath("/file/")+"\\"+bookService.getbyid(id).getBook_file());
		bookService.delete(id);
		try {
			response.sendRedirect("/book/admin/Book/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(ModelAndView mv,Model model,@PathVariable int id){
		model.addAttribute("entity", bookService.getbyid(id));
		model.addAttribute("book_map", book_mapService.getbyname(bookService.getbyid(id).getBook_file()));
		mv.setViewName("admin/Book/edit");
		model.addAttribute("columnlist",columnService.getallcoulumn());
		return mv;
	}
	@RequestMapping("/update")
	public void update(Book book,HttpServletResponse response,MultipartFile file,HttpServletRequest request){
		String filename;
		if(file.getSize()==0){
			System.out.println("oldfile");
			filename=bookService.getbyid(book.getBook_id()).getBook_file();
		}
		else{
			String oldfilename=bookService.getbyid(book.getBook_id()).getBook_file();
			bookService.deletefile(request.getServletContext().getRealPath("/file/")+"\\"+oldfilename);
			String fileFileName=file.getOriginalFilename();
			System.out.println("newfile"+fileFileName);
			filename=fileupdate.uploadFile(file, fileFileName,request.getServletContext().getRealPath("/file/"));
			
		}
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		book.setCate_id(categoryService.getbyid(columnService.getbyid(book.getColumn_id()).getCate_id()).getCate_id());
		book.setBook_data(Timestamp.valueOf(nowTime));
		book.setBook_file(filename);
		bookService.update(book);
		try {
			response.sendRedirect("/book/admin/Book/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/deletes")
	public void deletes(@RequestParam("id")int[] ids,HttpServletResponse response,Model model,HttpServletRequest request){
		
		for(int id:ids){
			bookService.deletefile(request.getServletContext().getRealPath("/file/")+"\\"+bookService.getbyid(id).getBook_file());
			String name= bookService.getbyid(id).getBook_file();
			
			bookService.delete(id);

		}
		try {
			response.sendRedirect("/book/admin/Book/list?pageNO=1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/getall")
	public ModelAndView getall(ModelAndView mv,Model model,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=4;
		int from=(pageNO-1)*size;
		List<Book> booklist=new ArrayList<Book>();
		booklist=bookService.getlistpager(from, size);	
		model.addAttribute("count", bookService.getall().size());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("booklist", booklist);
		mv.setViewName("booklist");
		return mv;
	}
	@RequestMapping("/get")
	public ModelAndView getbyid(ModelAndView mv,Model model,@RequestParam("id")int id,@RequestParam(required=false,defaultValue="1")int pageNO){
		int size=2;
		int from=(pageNO-1)*size;
		List<Book> list=new ArrayList<Book>();
		list=bookService.getbycolumn_id(id, from, size);
		model.addAttribute("count", bookService.getbycolumn_id(id).size());
		model.addAttribute("size", size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("book_list", list);
		model.addAttribute("id", id);
		model.addAttribute("column_name", columnService.getbyid(list.get(0).getColumn_id()).getColumn_name());
		mv.setViewName("details");
		//model.addAttribute("book", new BookAlllist(bookService.getbyid(id), book_mapService.getbyname(bookService.getbyid(id).getBook_file())));
		return mv;
	}
	@RequestMapping("/detail")
	public ModelAndView get(ModelAndView mv,@RequestParam("id")int id,Model model){
		model.addAttribute("book", bookService.getbyid(id));
		
		mv.setViewName("bookdetails");
		return mv;
	}
	@RequestMapping("download")
	public ResponseEntity<byte[]> down(@RequestParam("filename") String filename,Model model,HttpServletRequest request) throws Exception{
		return filedownload.download(filename,request.getServletContext().getRealPath("file/"));
	}
	
}
