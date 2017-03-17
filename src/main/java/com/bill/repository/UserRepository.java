package com.bill.repository;

import org.springframework.data.repository.CrudRepository;

import com.bill.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

}
