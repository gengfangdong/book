package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.UserDao;
import com.book.entity.User;
import com.book.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public String login(String user_name) {
		// TODO Auto-generated method stub
		return userDao.login(user_name);
	}

	@Override
	public void Add(User user) {
		// TODO Auto-generated method stub
		userDao.Add(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return userDao.getall();
	}

	@Override
	public List<User> getlist(int from, int to) {
		// TODO Auto-generated method stub
		return userDao.getlist(from, to);
	}

}
