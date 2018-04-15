package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.book.dao.provider.Bookprovider;
import com.book.entity.Book;

@Mapper
public interface BookDao {
	@Insert("INSERT INTO Tb_book(Book_name,Book_desc,Book_user,Book_data,Book_file,column_id,Cate_id) VALUES(#{Book_name},#{Book_desc},#{Book_user},#{Book_data},#{Book_file},#{column_id},#{Cate_id})")
	@Options(useGeneratedKeys=true,keyProperty="Book_id")
	public void insert(Book book);
	@Select("SELECT * FROM Tb_book")
	public List<Book> getallBook();
	@Select("SELECT count(*) FROM Tb_book")
	public int getcount();
	@UpdateProvider(type=Bookprovider.class,method="updateBook")
	public void update(Book book);
	@Select("SELECT * FROM Tb_book LIMIT #{from},#{to}")
	public List<Book> getlistpager(@Param("from")int from,@Param("to")int to);
	@Select("SELECT * FROM Tb_book WHERE Book_id=#{id}")
	public Book getbyid(@Param("id")int id);
	@Delete("DELETE FROM Tb_book WHERE Book_id=#{id}")
	public void delete(@Param("id")int id);
	@Select("SELECT * FROM Tb_book WHERE book_file=#{filename}")
	public Book getbyfilename(@Param("filename")String filename);
	@Select("SELECT * FROM Tb_book WHERE column_id=#{id} LIMIT #{from},#{to}")
	public List<Book> getbycolumn_id(@Param("id")int id,@Param("from")int from,@Param("to")int to);
	@Select("SELECT * FROM Tb_book WHERE column_id=#{id}")
	public List<Book> getbycolumn(@Param("id")int id);
}
