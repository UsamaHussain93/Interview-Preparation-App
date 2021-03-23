package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "answers" })
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
	@SequenceGenerator(name="question_generator", sequenceName = "question_seq", allocationSize=1)
	private int id; 
	
	@Column
	private String description;
	
	private QuestionType questionType;
	
	private QuestionTopic questionTopic;

	@OneToOne(mappedBy = "question")
	Answer answer;
	
	public Question() {
		
	}
	
	public Question(int id, String description, Answer answer) {
		super();
		this.id = id;
		this.description = description;
		this.answer = answer;
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

	public Answer getAnswers() {
		return answer;
	}

	public void setAnswers(Answer answers) {
		this.answer = answers;
	}

	public Answer getCorrectAnswer() {
//		Answer answer = null;
//		for(Answer a: answers) {
//			if(a.isCorrectAnswer())
//				answer = a;
//		}
//		return answer;
		return null;
	}

	
	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionTopic getQuestionTopic() {
		return questionTopic;
	}

	public void setQuestionTopic(QuestionTopic questionTopic) {
		this.questionTopic = questionTopic;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", interviewType=" + questionType + ", answers="
				+ answer + "]";
	}

	public QuestionType getInterviewType() {
		return questionType;
	}

	public void setInterviewType(QuestionType interviewType) {
		this.questionType = interviewType;
	}
	
}
