package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductDAO {
	
  @Autowired
  ProductRepository dao;  
  
  public Product save(Product p) {
	  
	 return  dao.save(p);
  }
  public Product findProduct(String code) {
	 Optional<Product> data= dao.findById(code);
	 return data.orElse(null);
  }  
  public List<Product> getAllProducts(){
	  return dao.findAll();
  }
  public List<Product> getPageProducts(Integer pageNo, Integer pageSize, String sortBy)
  {   //PagingAndSortingRepository 分頁物件 
      Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
      Page<Product> pagedResult = dao.findAll(paging);       
      if(pagedResult.hasContent()) {
          return pagedResult.getContent();
      } else {
          return new ArrayList<Product>();
      }
  }
}

