package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ChatServiceImpl;
import com.example.demo.vo.Chat;
import com.example.demo.vo.Employee;
@CrossOrigin()
@RestController
@RequestMapping("/chat")
public class ChatController {
	@Autowired
	private ChatServiceImpl csi;
	
	@PostMapping("/add")
	public void add(@RequestBody Chat chat)
	{
		
		csi.addChat(chat);
	}
	
	@GetMapping("/queryAllChat")
	public List<Chat> getAll()
	{
		return csi.queryAllChat();
	}
	

}