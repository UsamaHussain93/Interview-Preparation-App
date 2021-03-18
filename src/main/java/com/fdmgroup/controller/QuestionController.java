package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.dao.QuestionDao;
import com.fdmgroup.model.Question;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class QuestionController {
	
	@Autowired
	QuestionDao qDao;
	
	@GetMapping("/all-questions")
	public List<Question> getAllUsers(){
		System.out.println("GET ALL QUESTIONS");
		List<Question> foundQuestions = new ArrayList<Question>();
		qDao.findAll().forEach(question -> foundQuestions.add(question));
	
		for(Question q : foundQuestions) {
			System.out.println(q);
		}
		return foundQuestions;
	}
	
	@GetMapping("/question/{id}")
	public Question getQuestion(@PathVariable int id) {
		return qDao.findById(id).orElse(null);
		
	}
	
	@PostMapping("/question")
	public Question addQuestion(@RequestBody Question incomingQuestion) {
		return qDao.save(incomingQuestion);
	}
	
	@DeleteMapping("/question/{id}")
	public void deleteQuestion(@PathVariable int id) {
		Question foundQuestion = qDao.findById(id).orElse(null);
		qDao.delete(foundQuestion);
	}
	
	@PutMapping("/question")
	public Question updateQuestion(@RequestBody Question incomingQuestion) {
		return qDao.save(incomingQuestion);
	}
}
