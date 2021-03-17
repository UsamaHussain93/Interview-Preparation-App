package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
	private int id; 
	
	private String description;
	
	
	@OneToMany(mappedBy = "question")
	List<Answer> answers;
	
	public Question() {
		
	}
	
	public Question(int id, String description, List<Answer> answers) {
		super();
		this.id = id;
		this.description = description;
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer getCorrectAnswer() {
		Answer answer = null;
		for(Answer a: answers) {
			if(a.isCorrectAnswer())
				answer = a;
		}
		return answer;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + "]";
	}
	
}
