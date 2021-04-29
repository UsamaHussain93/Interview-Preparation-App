package com.fdmgroup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "question" })
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_generator")
	@SequenceGenerator(name="answer_generator", sequenceName = "answer_seq", allocationSize=1)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "question_id")
	private Question question;
	
	@Column
    private String answerText;
    
	@Column
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
		return "Answer [id=" + id + ", answerText=" + answerText + "]";
	}

	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}

	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}
    
    
}
