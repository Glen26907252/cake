package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.demo.vo.Products;

@Mapper
public interface ProductMapper {
	
	@Select("select * from products order by id desc")
	List<Products> getAll();
	
}