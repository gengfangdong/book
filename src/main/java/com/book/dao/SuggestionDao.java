package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.book.dao.provider.Suggestionprovider;
import com.book.entity.Suggestion;

@Mapper
public interface SuggestionDao {
	@Insert("INSERT INTO Suggestion(Suggestion_desc,Suggestion_qq,Suggestion_flag) VALUE(#{Suggestion_desc},#{Suggestion_qq},#{Suggestion_flag})")
	@Options(useGeneratedKeys=true,keyProperty="Suggestion_id")
	public void Addsuggestion(Suggestion suggestion);
	@Select("SELECT * FROM Suggestion WHERE Suggestion_flag=#{flag} LIMIT #{from},#{to}")
	public List<Suggestion>getallflag(@Param("from")int from,@Param("to")int to,@Param("flag")int flag);
	@UpdateProvider(type=Suggestionprovider.class,method="update")
	public void update(Suggestion suggestion);
	@Select("SELECT count(*) from Suggestion")
	public int getall();
	@Delete("DELETE FROM Suggestion WHERE Suggestion_id=#{id}")
	public void delete(@Param("id")int id);
}
