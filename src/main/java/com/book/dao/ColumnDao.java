package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.book.dao.provider.Columnprovider;
import com.book.entity.Book_column;


@Mapper
public interface ColumnDao {
	@Insert("INSERT INTO Colum(column_name,column_desc,Cate_id) values(#{Column_name},#{Column_desc},#{Cate_id})")
	@Options(useGeneratedKeys=true,keyProperty="column_id")
	public void add_column(Book_column book_column);
	@Select("SELECT * FROM Colum")
	public List<Book_column> getallcolumn();
	@Select("SELECT * FROM Colum LIMIT #{from},#{to}")
	public List<Book_column> getlistpager(@Param("from")int from,@Param("to")int to);
	@Select("SELECT * FROM Colum WHERE column_id=#{id}")
	public Book_column getbyid(@Param("id")int id);
	@Delete("DELETE FROM Colum WHERE column_id=#{id}")
	public void delete(@Param("id")int id);
	@UpdateProvider(type=Columnprovider.class,method="update")
	public void update(Book_column column);
	@Select("SELECT * FROM Colum WHERE Cate_id=#{id} LIMIT #{from},#{to}")
	public List<Book_column> getbycate_id(@Param("id") int id,@Param("from")int from,@Param("to")int to);
	@Select("SELECT * FROM Colum WHERE Cate_id=#{id}")
	public List<Book_column> getbyCate_id(@Param("id")int id);
}
