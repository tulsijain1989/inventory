package com.bill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class SalesItem {
	
	@Id
	@GeneratedValue
	@Column(name="SITEM_ID")
	private Long sItem_id;
		
	@Column(name="QUANTITY")
	private String quantity;
	
	@Column(name="PRICE")
	private String price;		
	
	@Column(name="TOTAL")
	private String total;
	
	/*@OneToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product_id;
*/
		
	@ManyToOne
	private Sales sales;

	public Long getsItem_id() {
		return sItem_id;
	}

	public void setsItem_id(Long sItem_id) {
		this.sItem_id = sItem_id;
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

	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}



}
