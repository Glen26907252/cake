package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.vo.Employee;


public interface  EmployeeService {
	void addEmployee(Employee employee);
	List<Employee> queryAllEmployee();
	Employee queryMemberById(int id);
	

}
