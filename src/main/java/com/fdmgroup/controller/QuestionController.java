package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fdmgroup.dao.AnswerDao;
import com.fdmgroup.dao.LinkQADao;
import com.fdmgroup.dao.QuestionDao;
import com.fdmgroup.model.Answer;
import com.fdmgroup.model.Question;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class QuestionController {
	
	@Autowired
	QuestionDao qDao;
	
	@Autowired
	AnswerDao aDao;
	
	@Autowired
	LinkQADao qaDao;
	
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
	
	@PostMapping("/add-question")
	public Question addQuestion(@RequestBody Question incomingQuestion) {
		System.out.println(incomingQuestion);
		return qDao.save(incomingQuestion);
	}
	

	@PostMapping("/add-answer")
	public Answer addAnswer(@RequestBody Answer incomingAnswers) 
	{
		System.out.println(incomingAnswers);
		return aDao.save(incomingAnswers);
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
	
	@PostMapping("/link")
	public LinkQA basicLink(@RequestBody LinkQA qa) {
		System.out.println("Link! Listen!");
		
		System.out.println(">>> qa:" + qa);

		
		Optional<Question> q = qDao.findById(qa.getqId());
		Question question = null;
		Answer answer = null;
		
		Optional<Answer> a = aDao.findById(qa.getaId());

		if(a.isPresent()) {
			 answer = a.get();
			if(q.isPresent()) {
				question = q.get();
				
				question.setAnswer(answer);
				answer.setQuestion(question);
				
				qDao.save(question);
				aDao.save(answer);
			}
		}
		return qa;
	}
}
