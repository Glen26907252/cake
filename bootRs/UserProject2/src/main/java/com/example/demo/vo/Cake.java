//package com.example.demo.vo;
//
//import lombok.Data;
//import lombok.ToString;
//
//@Data
//public class Cake {
//	private Integer id;
//	private String item;
//	private String itemName;
//	private Integer amount;
//	private Integer subtotal;
//	
//	public Cake(String item, String itemName, Integer amount, Integer subtotal ) {
//		super();
//		this.item = item;
//		this.itemName = itemName;
//		this.amount = amount;
//		this.subtotal = subtotal;
//		
//	}
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getItem() {
//		return item;
//	}
//	public void setItem(String item) {
//		this.item = item;
//	}
//	public String getItemName() {
//		return itemName;
//	}
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
//	public Integer getAmount() {
//		return amount;
//	}
//	public void setAmount(Integer amount) {
//		this.amount = amount;
//	}
//	public Integer getSubtotal() {
//		return subtotal;
//	}
//	public void setSubtotal(Integer subtotal) {
//		this.subtotal = subtotal;
//	}
//	public Cake() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//
//	
//
//}


/////////////////////////////////////////////////////


package com.example.demo.vo;

import lombok.Data;
import lombok.ToString;

@Data
public class Cake {
	private Integer id;
	private String item;
	private String item_name;
	private Integer amount;
	private Integer subtotal;
	
	public Cake(String item, String item_name, Integer amount, Integer subtotal ) {
		super();
		this.item = item;
		this.item_name = item_name;
		this.amount = amount;
		this.subtotal = subtotal;
		
	}
	
	public Cake() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
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