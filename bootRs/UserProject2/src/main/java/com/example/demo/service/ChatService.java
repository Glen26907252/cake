package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Chat;
import com.example.demo.vo.Employee;

public interface ChatService {
	void addChat(Chat chat);
	List<Chat> queryAllChat();

}