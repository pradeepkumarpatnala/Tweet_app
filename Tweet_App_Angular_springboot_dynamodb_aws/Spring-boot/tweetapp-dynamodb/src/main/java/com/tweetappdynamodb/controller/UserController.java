package com.tweetappdynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetappdynamodb.model.User;
import com.tweetappdynamodb.repository.UserRepository;
import com.tweetappdynamodb.service.UserService;

@RestController
@RequestMapping("/api/v1.0/userService")
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		
		 return userService.getAllUsers();
	}
	
	@PostMapping("/register")
	public void signupUser(@RequestBody User user) {
		userService.signupUser(user);
	}
	
	@GetMapping("/login")
	public List<User> loginUser(@RequestParam String username,@RequestParam String password) {
		return userService.authenticateUser(username, password);
	}
	
	@PutMapping("/forgotPassword")
	public void forgotPassword(@RequestBody User user ){
		List<User> users=userService.checkUserExists(user.getUsername());
		User updateUser=users.get(0);
		updateUser.setPassword(user.getPassword());
		userService.forgotPassword(updateUser);
	}
	
	@GetMapping("/checkUserExists")
	public List<User> checkUserExists(@RequestParam String username){
		return userService.checkUserExists(username);
	}
	
}
