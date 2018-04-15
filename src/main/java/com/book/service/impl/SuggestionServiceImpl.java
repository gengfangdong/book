package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.SuggestionDao;
import com.book.entity.Suggestion;
import com.book.service.SuggestionService;
@Service
public class SuggestionServiceImpl implements SuggestionService{
	@Autowired
	private SuggestionDao suggestionDao;
	@Override
	public void add(Suggestion suggestion) {
		// TODO Auto-generated method stub
		suggestionDao.Addsuggestion(suggestion);
	}

	@Override
	public List<Suggestion> getallflag(int from, int to, int flag) {
		// TODO Auto-generated method stub
		return suggestionDao.getallflag(from, to, flag);
	}

	@Override
	public void update(Suggestion suggestion) {
		// TODO Auto-generated method stub
		suggestionDao.update(suggestion);
	}

	@Override
	public int getall() {
		// TODO Auto-generated method stub
		return suggestionDao.getall();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		suggestionDao.delete(id);
	}

}
