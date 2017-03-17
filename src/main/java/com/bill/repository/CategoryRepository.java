package com.bill.repository;

import org.springframework.data.repository.CrudRepository;

import com.bill.entity.Category;


public interface CategoryRepository extends CrudRepository<Category, Long>{
	

}
