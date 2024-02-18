package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.User;



public interface userService {
	void addUser(User user);
	List<User> queryAllUser();

}