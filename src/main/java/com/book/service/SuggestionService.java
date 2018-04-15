package com.book.service;

import java.util.List;

import com.book.entity.Suggestion;

public interface SuggestionService {
	public void add(Suggestion suggestion);
	public List<Suggestion> getallflag(int from,int to,int flag);
	public void update(Suggestion suggestion);
	public int getall();
	public void delete(int id);
}
