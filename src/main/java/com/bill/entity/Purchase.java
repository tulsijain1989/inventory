package com.bill.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Purchase {
	
	@Id
	@GeneratedValue
	@Column(name="PURCHASE_ID")
	private Long purchase_id;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="QUANTITY")
	private String quantity;
	
	@Column(name="PRICE")
	private String price;
	
	@Column(name="TOTAL")
	private String total;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	private Supplier supplier_id;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product_id;

	public Long getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(Long purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Supplier getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Supplier supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Product getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Product product_id) {
		this.product_id = product_id;
	}
	
	

	

}
