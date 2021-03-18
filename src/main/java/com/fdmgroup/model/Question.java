package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
	@SequenceGenerator(name="question_generator", sequenceName = "question_seq", allocationSize=1)
	private int id; 
	
	@Column
	private String description;
	
	private InterviewType interviewType;

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
		return "Question [id=" + id + ", description=" + description + ", interviewType=" + interviewType + ", answers="
				+ answers + "]";
	}

	public InterviewType getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(InterviewType interviewType) {
		this.interviewType = interviewType;
	}
	
}
