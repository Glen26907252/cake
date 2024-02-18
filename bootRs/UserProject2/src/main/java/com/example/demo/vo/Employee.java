package com.example.demo.vo;

import lombok.Data;

@Data
public class Employee {
	private Integer id;
	private String name;//姓名
	private String address;//部門
	private String department;//生日
	private String gender;//性別
	public Employee(String name, String address, String department, String gender) {
		super();
		this.name = name;
		this.address = address;
		this.department = department;
		this.gender = gender;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}