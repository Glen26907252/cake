package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CakeServiceImpl;
import com.example.demo.vo.Cake;
import com.example.demo.vo.Employee;
@CrossOrigin()
@RestController
@RequestMapping("/cake")
public class CakeController {
	@Autowired
	private CakeServiceImpl csi;
	
	@PostMapping("/add")
	public void add(@RequestBody Cake cake)
	{
		
		csi.addCake(cake);
	}
	
	@GetMapping("/queryAllCake")
	public List<Cake> getAll()
	{
		return csi.queryAllCake();
	}
	
	@DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        csi.deleteCakeById(id);
    }
	
	@PutMapping("/update/{id}")
    public void updateById(@PathVariable int id, @RequestBody Cake cake) {
        cake.setId(id); // Ensure that the Cake object has the correct ID
        csi.updateCakeById(cake);
    }

}