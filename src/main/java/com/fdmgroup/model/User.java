package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Userr")
public class User {
	@Id
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	public User(int id, String username, String password, String email, AccountType type) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}
	public User(String username, String password, String email, AccountType type) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}
	
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", type="
				+ type + "]";
	}
	

}
