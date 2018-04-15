package com.book.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.book.entity.Book_column;



public class Columnprovider {
	public String update(Book_column column){
		return new SQL(){{
				UPDATE("Colum");
				SET("column_name=#{column_name},column_desc=#{column_desc},Cate_id=#{Cate_id}");
				WHERE("column_id=#{column_id}");}
		}.toString();
	}
}
