package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.vo.Products;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper pm;
	
	@Override
	public List<Products> queryAllProducts() {
		// TODO Auto-generated method stub
		return pm.getAll();
	}

}