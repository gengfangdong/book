package com.book.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import com.book.entity.Suggestion;

public class Suggestionprovider {
	public String update(Suggestion suggestion){
		return new SQL(){
			{
				UPDATE("Suggestion");
				SET("Suggestion_desc=#{Suggestion_desc},Suggestion_qq=#{Suggestion_qq},Suggestion_flag=#{Suggestion_flag}");
				WHERE("Suggestion_id=#{Suggestion_id}");
			}
		}.toString();
	}
}
