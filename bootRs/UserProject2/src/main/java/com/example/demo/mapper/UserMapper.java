package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Chat;
import com.example.demo.vo.User;
@Mapper
public interface UserMapper {
	@Insert("insert into user(name,email,telphone,job,age) "
			+ "values(#{name},#{email},#{telphone},#{job},#{age})")
	public void add(User user);
	
	
	@Select("select * from user order by uid desc")
	List<User> getAll();

}