package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.book.dao.provider.Userprovider;
import com.book.entity.User;
@Mapper
public interface UserDao {
	@Select("SELECT user_password FROM user WHERE user_name=#{name}")
	public String login(@Param("name")String user_name);
	@Insert("INSERT INTO user(user_name,user_password) VALUES(#{user_name},#{user_password})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public void Add(User user);
	@UpdateProvider(type=Userprovider.class,method="updateUser")
	public void update(User user);
	@Delete("DELETE FROM user WHERE id=#{id}")
	public void delete(@Param("id")int id);
	@Select("SELECT * FROM user")
	public List<User> getall();
	@Select("SELECT * FROM user LIMIT #{from},#{to}")
	public List<User> getlist(@Param("from")int from,@Param("to")int to);
}
