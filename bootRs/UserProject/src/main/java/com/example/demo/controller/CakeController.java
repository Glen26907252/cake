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
	public Cake addCake(String item, String item_name, Integer amount, Integer subtotal) {		
			
	    Cake cake = new Cake(item, item_name, amount, subtotal);
	    return cakeRepository.save(cake);
	}


	@PostMapping("/add2")
	public Cake addUser2(@RequestBody Cake cake) {		
		
		return cakeRepository.save(cake);
	}
	
	@PostMapping(value = "/delete")
	public void delCake(Integer id) {
		cakeRepository.deleteById(id);
	}
}
