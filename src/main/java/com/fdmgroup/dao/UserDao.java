package com.fdmgroup.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.model.User;

public interface UserDao extends CrudRepository<User, Integer>{
	
}
