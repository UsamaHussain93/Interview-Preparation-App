package com.fdmgroup.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LinkQA {
	
	@Id
	int qId;
	
	int aId;
	
	public LinkQA() {
		
	}
	
	public LinkQA(int aId, int qId) {
		super();
		this.aId = aId;
		this.qId = qId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	@Override
	public String toString() {
		return "LinkQA [aId=" + aId + ", qId=" + qId + "]";
	}
	
	
}
