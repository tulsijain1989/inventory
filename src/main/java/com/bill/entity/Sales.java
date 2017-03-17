package com.bill.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Sales {
	
	@Id
	@GeneratedValue
	@Column(name="SALES_ID")
	private Long sales_id;
	
	@Column(name="DATE")
	private Date date;
	
	@OneToOne
	//@JoinTable(name="CUSTOMER_ID")
	Customer customer;
	
	@Column(name="TAX")
	private String tax;
	
	@Column(name="DISCOUNT")
	private String discount;
		
	@Column(name="TOTAL")
	private String total;

	public Long getSales_id() {
		return sales_id;
	}

	public void setSales_id(Long sales_id) {
		this.sales_id = sales_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
/*	@OneToMany
	@JoinTable(name="CUSTOMER_ID")
	SalesItem sItem_id;*/
	



}
