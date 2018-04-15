package com.book.entity;

import java.io.Serializable;

public class CateGory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Cate_id;
	private String Cate_name;
	private String Cate_desc;
	public CateGory() {
		super();
	}
	public CateGory(String cate_name, String cate_desc) {
		super();
		Cate_name = cate_name;
		Cate_desc = cate_desc;
	}
	public CateGory(Integer cate_id, String cate_name, String cate_desc) {
		super();
		Cate_id = cate_id;
		Cate_name = cate_name;
		Cate_desc = cate_desc;
	}
	public Integer getCate_id() {
		return Cate_id;
	}
	public void setCate_id(Integer cate_id) {
		Cate_id = cate_id;
	}
	public String getCate_name() {
		return Cate_name;
	}
	public void setCate_name(String cate_name) {
		Cate_name = cate_name;
	}
	public String getCate_desc() {
		return Cate_desc;
	}
	public void setCate_desc(String cate_desc) {
		Cate_desc = cate_desc;
	}
	@Override
	public String toString() {
		return "CateGory [Cate_id=" + Cate_id + ", Cate_name=" + Cate_name + ", Cate_desc=" + Cate_desc + "]";
	}
	
	
	
}
