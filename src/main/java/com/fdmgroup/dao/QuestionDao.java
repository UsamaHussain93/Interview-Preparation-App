package com.fdmgroup.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.model.Question;
import com.fdmgroup.model.User;

public interface QuestionDao extends CrudRepository<Question, Integer>{
	
}

