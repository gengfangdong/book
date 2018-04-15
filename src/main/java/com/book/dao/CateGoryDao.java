package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.book.dao.provider.Categoryprovider;
import com.book.entity.CateGory;


@Mapper
public interface CateGoryDao{
	@Insert("INSERT INTO CateGory(Cate_name,Cate_desc) values(#{Cate_name},#{Cate_desc})")//注解方式添加数据
	@Options(useGeneratedKeys=true,keyProperty="Cate_id")//自增主键,配置主键
	public void Cate_add(CateGory cateGory);
	
	@Select("SELECT * FROM CateGory")
	public List<CateGory> selectAllCategory();
	
	@Delete(value = {"DELETE FROM CateGory WHERE Cate_id=#{Cate_id}" })
	public void delet(@Param("Cate_id") int id);
	@Select("SELECT * FROM CateGory WHERE Cate_id=#{id}")
	public CateGory getbyid(@Param("id")int id);
	@Select("SELECT * FROM CateGory LIMIT #{from},#{to}")
	public List<CateGory> getlistpager(@Param("from")int from,@Param("to")int to);
	@Select("SELECT COUNT(*) FROM CateGory")
	public int getcount();
	@UpdateProvider(type=Categoryprovider.class,method="update")
	public void update(CateGory cateGory);
}
