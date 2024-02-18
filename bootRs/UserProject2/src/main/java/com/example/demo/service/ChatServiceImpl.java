package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.ChatMapper;
import com.example.demo.vo.Chat;
@Service
public class ChatServiceImpl implements ChatService{
	@Autowired
	private ChatMapper cm;

	@Override
	public void addChat(Chat chat) {
		
		cm.add(chat);
	}

	@Override
	public List<Chat> queryAllChat() {
		// TODO Auto-generated method stub
		return cm.getAll();
	}
	

}