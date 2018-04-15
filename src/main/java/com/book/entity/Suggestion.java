package com.book.entity;

import java.io.Serializable;

public class Suggestion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Suggestion_id;
	private String Suggestion_desc;
	private Integer Suggestion_qq;
	private Integer Suggestion_flag;
	
	public Suggestion() {
		super();
	}

	public Suggestion(String suggestion_desc, Integer suggestion_qq, Integer suggestion_flag) {
		super();
		Suggestion_desc = suggestion_desc;
		Suggestion_qq = suggestion_qq;
		Suggestion_flag = suggestion_flag;
	}

	public Integer getSuggestion_id() {
		return Suggestion_id;
	}

	public void setSuggestion_id(Integer suggestion_id) {
		Suggestion_id = suggestion_id;
	}

	public String getSuggestion_desc() {
		return Suggestion_desc;
	}

	public void setSuggestion_desc(String suggestion_desc) {
		Suggestion_desc = suggestion_desc;
	}

	public Integer getSuggestion_qq() {
		return Suggestion_qq;
	}

	public void setSuggestion_qq(Integer suggestion_qq) {
		Suggestion_qq = suggestion_qq;
	}

	public Integer getSuggestion_flag() {
		return Suggestion_flag;
	}

	public void setSuggestion_flag(Integer suggestion_flag) {
		Suggestion_flag = suggestion_flag;
	}

	@Override
	public String toString() {
		return "Suggestion [Suggestion_id=" + Suggestion_id + ", Suggestion_desc=" + Suggestion_desc
				+ ", Suggestion_qq=" + Suggestion_qq + ", Suggestion_flag=" + Suggestion_flag + "]";
	}
	
}
