package com.bill.repository;

import org.springframework.data.repository.CrudRepository;

import com.bill.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	

}
