//package com.fdmgroup.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fdmgroup.dao.UserDao;
//import com.fdmgroup.model.User;
//
//@RestController
//public class UserController {
//	@Autowired
//	UserDao userDao;
//	
//	@GetMapping("/users")
//	public List<User> getAllUsers(){
//		List<User> foundUsers = new ArrayList<>();
//		userDao.findAll().forEach(user -> foundUsers.add(user));
//		return foundUsers;
//	}
//	
//}
