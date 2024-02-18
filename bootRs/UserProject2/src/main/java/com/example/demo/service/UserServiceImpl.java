package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;
@Service
public class UserServiceImpl implements userService{
	@Autowired
	private UserMapper em;
	
	@Override
	public void addUser(User user) {
		em.add(user);
		
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		return em.getAll();
	}

}