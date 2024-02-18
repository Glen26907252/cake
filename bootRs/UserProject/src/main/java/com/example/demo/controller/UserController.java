package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

@CrossOrigin(maxAge=3600,allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/queryAll")
	public List<User> getList() {
		return userRepository.findAll();
	}
	@PostMapping("/add")
	public User addUser(String name,String age,String telephone,
			String email,String job) {		
		
		User user=new User(name,age,telephone,email,job);
		
		return userRepository.save(user);
	}
	
	@PostMapping("/add2")
	public User addUser2(@RequestBody User user) {		
		
		return userRepository.save(user);
	}
	
	@PostMapping(value = "/delete")
	public void delUser(Integer uid) {
		userRepository.deleteById(uid);
	}
}
