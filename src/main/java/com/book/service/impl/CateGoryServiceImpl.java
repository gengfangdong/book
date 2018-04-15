package com.book.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.CateGoryDao;
import com.book.entity.CateGory;
import com.book.service.CateGoryService;


@Service
public class CateGoryServiceImpl implements CateGoryService {
	@Autowired
	private CateGoryDao cateGoryDao;
	@Override
	public void Cate_add(CateGory cateGory) {
		// TODO Auto-generated method stub
		cateGoryDao.Cate_add(cateGory);
	}
	@Override
	public List<CateGory> selectAllCategory() {
		// TODO Auto-generated method stub
		return cateGoryDao.selectAllCategory();
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cateGoryDao.delet(id);
	}
	@Override
	public CateGory getbyid(int id) {
		// TODO Auto-generated method stub
		return cateGoryDao.getbyid(id);
	}
	@Override
	public List<CateGory> getlistpager(int from, int to) {
		// TODO Auto-generated method stub
		return cateGoryDao.getlistpager(from, to);
	}
	@Override
	public int getcount() {
		// TODO Auto-generated method stub
		return cateGoryDao.getcount();
	}
	@Override
	public void update(CateGory cateGory) {
		// TODO Auto-generated method stub
		cateGoryDao.update(cateGory);
	}
	@Override
	public void deletes(int[] ids) {
		// TODO Auto-generated method stub
		for(int id:ids){
			cateGoryDao.delet(id);
		}
	}

}
