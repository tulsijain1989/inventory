package com.bill.repository;

import org.springframework.data.repository.CrudRepository;

import com.bill.entity.Purchase;


public interface PurchaseRepository extends CrudRepository<Purchase, Long>{
	

}
