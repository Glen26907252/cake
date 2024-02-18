package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Cake;
import com.example.demo.vo.Employee;

public interface CakeService {
	void addCake(Cake cake);
	List<Cake> queryAllCake();
	void deleteCakeById(int id); 
    void updateCakeById(Cake cake);

	
}