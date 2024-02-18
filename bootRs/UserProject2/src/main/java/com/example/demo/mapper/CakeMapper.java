//package com.example.demo.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
//
//import com.example.demo.vo.Cake;
//
//@Mapper
//public interface CakeMapper {
//	@Insert("insert into cake(item,itemName,amount,subtotal) "
//			+ "values(#{item},#{itemName},#{amount},#{subtotal})")
//	public void add(Cake cake);
//	
//	
//	@Select("select * from cake order by id desc")
//	List<Cake> getAll();
//	
//	@Delete("delete from cake where id = #{id}")
//    void deleteById(int id);
//	
//	@Update("update cake set item=#{item}, itemName=#{itemName}, amount=#{amount}, subtotal=#{subtotal} where id=#{id}")
//    void updateById(Cake cake);
//
//}



/////////////////////////////////////////////////


package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Cake;

@Mapper
public interface CakeMapper {
	@Insert("insert into cake(item,item_name,amount,subtotal) "
			+ "values(#{item},#{item_name},#{amount},#{subtotal})")
	public void add(Cake cake);
	
	
	@Select("select * from cake order by id desc")
	List<Cake> getAll();
	
	@Delete("delete from cake where id = #{id}")
    void deleteById(int id);
	
	@Update("update cake set item=#{item}, item_name=#{item_name}, amount=#{amount}, subtotal=#{subtotal} where id=#{id}")
    void updateById(Cake cake);

}