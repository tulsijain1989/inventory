package com.bill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="CUSTOMER_ID")
	private Long customer_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String Address;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PAN")
	private String pan;
	
	@Column(name="DESCRIPTION")
	private String description;

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}

/*{
"customer_id": 1,
"name": "Tulsi Jain",
"phone": "9776593835",
"email": "tulsirock@gmail.com",
"pan": "AKIPJ122389",
"description": "kesinga guy",
"address": "kesinga"
}*/