package com.book.service;

import java.util.List;

import com.book.entity.CateGory;



public interface CateGoryService {
	public void Cate_add(CateGory cateGory);
	public List<CateGory> selectAllCategory();
	public void delete(int id);
	public CateGory getbyid(int id);
	public List<CateGory> getlistpager(int from,int to);
	public int getcount();
	public void update(CateGory cateGory);
	public void deletes(int[] ids);
}
