package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.dao.AnswerDao;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.Answer;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerController {
	@Autowired
	AnswerDao answerDao;
	
	@GetMapping("/answers")
	public List<Answer> getAllAnswers(){
		List<Answer> foundAnswers = new ArrayList<>();
		answerDao.findAll().forEach(answer -> foundAnswers.add(answer));
		return foundAnswers;
	}
}
