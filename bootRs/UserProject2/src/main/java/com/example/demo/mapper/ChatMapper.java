package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Chat;
import com.example.demo.vo.Employee;

@Mapper
public interface ChatMapper {
	@Insert("insert into chat(name,subject,content) "
			+ "values(#{name},#{subject},#{content})")
	public void add(Chat chat);
	
	
	@Select("select * from chat order by id desc")
	List<Chat> getAll();

}