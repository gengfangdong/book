package com.book.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.book.entity.CateGory;



public class Categoryprovider {
	public String update(CateGory cateGory){
		return new SQL(){
			{
				UPDATE("CateGory");
				SET("cate_name=#{cate_name},cate_desc=#{cate_desc}");
				WHERE("cate_id=#{cate_id}");
			}
		}.toString();
	}
}
