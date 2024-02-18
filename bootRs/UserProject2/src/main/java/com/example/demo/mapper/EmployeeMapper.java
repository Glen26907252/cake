package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Employee;

@Mapper
public interface EmployeeMapper {
	@Insert("insert into em(name,address,department,gender) "
			+ "values(#{name},#{address},#{department},#{gender})")
	public void add(Employee employee);
	
	
	@Select("select * from em")
	List<Employee> getAll();


	public Employee getId(int id);//test
	
	
	

}
