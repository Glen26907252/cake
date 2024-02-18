package com.example.demo.vo;

import lombok.Data;

@Data
public class User {
	
	private Integer uid;
	private String name;
	private String age;
	public User( ) {
	}
	
	
	public User(String name, String age, String telephone, String email, String job) {
		super();
		this.name = name;
		this.age = age;
		this.telephone = telephone;
		this.email = email;
		this.job = job;
	}


	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	private String telephone;
	private String email;
	private String job;
}
