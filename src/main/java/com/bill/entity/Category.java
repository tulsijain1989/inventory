package com.bill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Long category_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="MEASUREMENT")
	private String measurement;
	
	
	public Category(){
		
	}
	
	
	
	public Category(Long category_id, String name, String measurement) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.measurement = measurement;
	}



	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	
	

}

/*
  {
      "category_id": 1,
      "name": "Cement",
      "measurement": "Bag"
    }
    */
