package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Products;
import com.example.demo.repository.ProductsRepository;

import java.util.List;

@CrossOrigin(maxAge=3600,allowedHeaders = "*")
@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository;
	
	@GetMapping("/queryAllProducts")
	public List<Products> getList() {
		return productsRepository.findAll();
	}
	
}
