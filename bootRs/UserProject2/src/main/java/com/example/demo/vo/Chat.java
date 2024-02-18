package com.example.demo.vo;

import lombok.Data;
import lombok.ToString;

@Data
public class Chat {
	private Integer id;
	private String name;
	private String subject;
	private String content;
	public Chat(String name, String subject, String content) {
		super();
		this.name = name;
		this.subject = subject;
		this.content = content;
	}
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
//	public Integer getId() {
//		return id;
//	}
//	
//	public String getName() {
//	    return name;
//	}
//
//	public String getSubject() {
//	    return subject;
//	}
//
//	public String getContent() {
//	    return content;
//	}
	

}