package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.book.entity.Book_map;

@Mapper
public interface Book_mapDao {
	@Insert("INSERT INTO Book_map(book_util,book_file) values(#{book_util},#{book_file})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public void insert(Book_map book_map);
	@Delete("DELETE FROM Book_map WHERE id=#{id}")
	public void delete(@Param("id") int id);
	@Select("SELECT * FROM Book_map WHERE id=#{id}")
	public Book_map getbyid(@Param("id")int id);
	@Select("SELECT * FROM Book_map")
	public List<Book_map> getall();
	@Delete("DELETE FROM Book_map WHERE book_file=#{filename}")
	public void delet(@Param("filename")String filename);
	@Select("SELECT * FROM Book_map WHERE book_file=#{filename}")
	public Book_map getbyname(@Param("filename")String name);
}
