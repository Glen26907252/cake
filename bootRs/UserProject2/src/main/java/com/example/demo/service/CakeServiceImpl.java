package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.mapper.CakeMapper;
import com.example.demo.vo.Cake;
@Service
public class CakeServiceImpl implements CakeService{
	@Autowired
	private CakeMapper cm;

	@Override
	public void addCake(Cake cake) {
		
		cm.add(cake);
	}

	@Override
	public List<Cake> queryAllCake() {
		// TODO Auto-generated method stub
		return cm.getAll();
	}

	@Override
    public void deleteCakeById(int id) {
        cm.deleteById(id);
    }
	
	@Override
	public void updateCakeById(Cake cake) {
	    // 請確保您的 CakeMapper 中有對應的更新方法，這裡假設為 updateById
	    cm.updateById(cake);
	}
	
}