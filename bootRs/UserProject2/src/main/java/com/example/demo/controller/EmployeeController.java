package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.vo.Employee;
@CrossOrigin()
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl esi;
	
	
	@PostMapping("/add")
	public void add(@RequestBody Employee employee)
	{
		esi.addEmployee(employee);
	}
	
	@GetMapping("/queryAllEmployee")
	public List<Employee> getAll()
	{
		return esi.queryAllEmployee();
	}

}
 