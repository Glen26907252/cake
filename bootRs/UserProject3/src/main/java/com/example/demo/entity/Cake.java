package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cake")
public class Cake {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String item;
	private String itemName;
	private Integer amount;
	private Integer subtotal;
	
	public Cake( ) {
	}
	
	
	public Cake(String item, String itemName, Integer amount, Integer subtotal) {
		super();
		this.item = item;
		this.itemName = itemName;
		this.amount = amount;
		this.subtotal = subtotal;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public Integer getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	
}

