package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeMapper em;
	@Override
	public void addEmployee(Employee employee) {
		em.add(employee);
		
	}

	@Override
	public List<Employee> queryAllEmployee() {
		
		return em.getAll();
	}

	@Override
	public Employee queryMemberById(int id) {
		
		return em.getId(id);
	}

}
