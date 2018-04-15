package com.book.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.book.entity.Book;


public class Bookprovider {
	public String updateBook(Book book){
		return new SQL(){{
			UPDATE("Tb_book");
			SET("Book_name=#{Book_name},Book_desc=#{Book_desc},Book_user=#{Book_user},Book_data=#{Book_data},Book_file=#{Book_file},column_id=#{column_id},Cate_id=#{Cate_id}");
			WHERE("Book_id=#{Book_id}");}
		}.toString();
	}
}
