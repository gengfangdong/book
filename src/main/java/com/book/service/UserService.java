package com.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.entity.User;

public interface UserService {
	public String login(String user_name);
	public void Add(User user);
	public void update(User user);
	public void delete(int id);
	public List<User> getall();
	public List<User> getlist(int from,int to);
}
