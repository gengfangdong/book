package com.book.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.book.entity.User;


public class Userprovider {
	public String updateUser(User user){
		return new SQL(){{
			UPDATE("user");
			SET("user_name=#{user_name},user_password=#{user_password}");
			WHERE("id=#{id}");}
		}.toString();
	}
}
