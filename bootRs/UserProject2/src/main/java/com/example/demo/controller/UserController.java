package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserServiceImpl;
import com.example.demo.vo.Employee;
import com.example.demo.vo.User;

@CrossOrigin(maxAge=3600,allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl usi;
	
	
	
	@PostMapping("/add")
	public void add(@RequestBody Employee employee)
	{
		usi.addUser(null);
	}
	
	@GetMapping("/queryAllUser")
	public List<User> getAll()
	{
		return usi.queryAllUser();
	}
	
	
}