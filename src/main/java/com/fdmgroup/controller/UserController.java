package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.AccountType;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserDao userDao;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> foundUsers = new ArrayList<>();
		userDao.findAll().forEach(user -> foundUsers.add(user));
		return foundUsers;
	}
	
	@GetMapping("/users/{userName}")
	public User getUser(@PathVariable String userName) {
	List<User> foundUsers = new ArrayList<>();
    userDao.findAll().forEach(user -> foundUsers.add(user));
    for(User u: foundUsers) {
    	if(u.getUsername().compareTo(userName) == 0) {
    		return u; 
    		}
    	}
    return null;
    }
	
	@PostMapping("/loginuser") //Tested in Postman: Success
	public User getUser(@RequestBody User incomingUser) {
		List<User> foundUsers = new ArrayList<>();
		userDao.findAll().forEach(user -> foundUsers.add(user));
			if(foundUsers.contains(incomingUser)) {
				int index = foundUsers.indexOf(incomingUser);
				return foundUsers.get(index);
//				return true;
			}
		else {
			return null;
		}
	}

	
	@PostMapping("/adduser") //Tested in Postman: Success
	public User addUser(@RequestBody User incomingUser) {
//		List<User>userList = (List<User>) userDao.findAll();
		List<User> foundUsers = new ArrayList<>();
		String userName = incomingUser.getUsername();
		String email = incomingUser.getEmail();
		AccountType accountType = incomingUser.getAccountType();
		userDao.findAll().forEach(user -> foundUsers.add(user));
		
		if(accountType == AccountType.Trainer) {
			System.out.println("Trainer Account creation requires admin access.");
			return null;
		}else {
			if(foundUsers.isEmpty())
			{
				System.out.println("Registering First User");
				return userDao.save(incomingUser);
			}
			else {
				for(User u: foundUsers) {
					if(u.getUsername().equals(userName) || u.getEmail().equals(email)) {
						System.out.println("Username or Email is already associated with another account");
						return null;
					}
					else {
						System.out.println("Registering New User");
						return userDao.save(incomingUser);
		    		}
		    	}
			}
		}
		return null;
	    
//		if(foundUsers.contains(incomingUser)) {
//			return null;
//		}
//		else {
//			return userDao.save(incomingUser);
//		}
	}
	
//	@DeleteMapping("/delete")
//	public void deleteUser(@RequestBody User incomingUser) {
//		//String userName = incomingUser.getUsername();
////		List<User>userList = (List<User>) userDao.findAll();
//		List<User> foundUsers = new ArrayList<>();
//		userDao.findAll().forEach(user -> foundUsers.add(user));                   FOR LATER USE
//		if(foundUser.contains(incomingUser)) {
//			userDao.delete(incomingUser);
//		}
//	}

	@PostMapping("/update")
	public User updateUser(@RequestBody User incomingUser) {
		return userDao.save(incomingUser);
	}

}
