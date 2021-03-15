package com.fdmgroup.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	private int id; 
	
	private String description;
	
	
	
	
	public Question() {
		
	}
	
	public Question(int id, String description) {
		super();
		this.id = id;
		this.description = description;
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + "]";
	}
	
}
