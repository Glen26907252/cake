package com.example.demo.vo;

import lombok.Data;
import lombok.ToString;

@Data
public class Products {
	private Integer id;
	private String product_id;
	private String name;
	private String descript;
	private String img;
	private Integer price;
	private String category;
	private String category2;
	
	public Products(String product_id, String name, String descript, String img,
					Integer price, String category, String category2) {
		
		super();
		this.product_id = product_id;
		this.name = name;
		this.descript = descript;
		this.img = img;
		this.price = price;
		this.category = category;
		this.category2 = category2;
		
	}
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	
	
}