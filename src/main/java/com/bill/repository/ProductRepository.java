package com.bill.repository;

import org.springframework.data.repository.CrudRepository;

import com.bill.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Long>{
	

}
