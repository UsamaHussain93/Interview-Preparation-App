package com.fdmgroup.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.model.Question;

public interface QuestionDao extends CrudRepository<Question, Integer>{

}
