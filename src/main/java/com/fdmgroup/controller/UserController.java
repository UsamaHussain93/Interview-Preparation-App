package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> foundUsers = new ArrayList<>();
		userDao.findAll().forEach(user -> foundUsers.add(user));
		return foundUsers;
	}
	@GetMapping("/users/{id}")
	public User getUser(int id) {
		return userDao.findById(id).orElse(null);
	}
	@PostMapping("/adduser")
	public User addUser(@RequestBody User incomingUser) {
		return userDao.save(incomingUser);
	}
	@DeleteMapping("/delete")
	public void deleteUser(int id) {
		User foundUser = userDao.findById(id).orElse(null);
		userDao.delete(foundUser);
	}
	@PostMapping("/update")
	public User updateUser(User incomingUser) {
		return userDao.save(incomingUser);
	}

}
