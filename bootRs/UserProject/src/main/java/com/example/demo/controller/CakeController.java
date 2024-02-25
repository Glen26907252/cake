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

import com.example.demo.entity.Cake;
import com.example.demo.repository.CakeRepository;

import java.util.List;

@CrossOrigin(maxAge=3600,allowedHeaders = "*")
@RestController
@RequestMapping("/cake")
public class CakeController {
	@Autowired
	private CakeRepository cakeRepository;
	
	@GetMapping("/queryAllCake")
	public List<Cake> getList() {
		return cakeRepository.findAll();
	}
	
	@PostMapping("/add")
	public Cake addUser2(@RequestBody Cake cake) {		
		
		return cakeRepository.save(cake);
	}
		
	@DeleteMapping(value = "/delete/{id}") // 修改路径，添加{id}作为路径参数
	public void delCake(@PathVariable Integer id) { // 添加@PathVariable注解来接收路径参数
	    cakeRepository.deleteById(id);
	}
		
	@PutMapping("/update/{id}")
	public Cake updateCake(@PathVariable Integer id, @RequestBody Cake updatedCake) {
	    return cakeRepository.findById(id).map(cake -> {
	        cake.setItem(updatedCake.getItem());
	        cake.setItem_name(updatedCake.getItem_name());
	        cake.setAmount(updatedCake.getAmount());
	        cake.setSubtotal(updatedCake.getSubtotal());
	        return cakeRepository.save(cake);
	    }).orElseThrow();
	}
}
