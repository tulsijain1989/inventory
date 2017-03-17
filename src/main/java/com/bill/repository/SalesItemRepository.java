package com.bill.repository;

import org.springframework.data.repository.CrudRepository;

import com.bill.entity.SalesItem;


public interface SalesItemRepository extends CrudRepository<SalesItem, Long>{
	

}
