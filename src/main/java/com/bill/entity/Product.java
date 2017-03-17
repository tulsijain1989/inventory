package com.bill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="PRODUCT_ID")
	Long product_id;
	
	@Column(name="NAME")
	String name;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	Category category_id;
	
	@Column(name="QUANTITY")
	String quantity;
	
	@Column(name="PRICE")
	String price;
	
	@Column(name="DESCRIPTION")
	String description;
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}


/*

{
    "product_id": 1,
    "name": "ACC",
    "category_id": {
      "category_id": 1
       },
    "quantity": "1",
    "price": "220",
    "description": "ACC normal Cement"
}

*/