package com.fdmgroup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToMany(mappedBy = "question")
//	@JoinColumn(name = "answer_id")
	private List<Answer> answer;
	
	public Question() {
		
	}
	
	public Question(int id, String description, List<Answer> answer) {
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

//	public List<Answer> getAnswers() {
//		return answers;
//	}
//
//	public void setAnswers(Answer answers) {
//		this.answers = answers;
//	}
	
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

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", questionType=" + questionType + "]";
	}	
}
