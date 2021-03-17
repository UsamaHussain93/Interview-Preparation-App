package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
    private String answerText;
    
    private boolean isCorrectAnswer;
    
    public Answer() {
    	
    }
    
	public Answer(int id, Question question, String answerText) {
		super();
		this.id = id;
		this.question = question;
		this.answerText = answerText;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", questionId=" + question.getId() + ", answerText=" + answerText + "]";
	}

	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}

	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}
    
    
}
