package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.UserDao;
import com.tweetapp.model.User;

public class UserService {
	
	public void triggerAppForNonLoggedInUsers() {
		System.out.println("Enter you choice");
		System.out.println("1. Register");
    	System.out.println("2. Login");
    	System.out.println("3. Forget Password");
    	Scanner in =new Scanner(System.in);
    	int a = in.nextInt();
    	
    	switch (a) {
    		case 1:
    			registerUser();
    			break;
    		case 2:
    			System.out.println("2. Login");
    			loginUser();
    			break;
    		case 3:
    			System.out.println("3. password");
    			break;
    		default:
    		    System.out.println("Looking forward to the Weekend");
    			
    	}
    	in.close();
	}
	
	public void registerUser() {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your First Name");
		String firstName=in.nextLine();
		System.out.println("Enter your Last Name");
		String lastName=in.nextLine();
		System.out.println("Enter your gender");
		String gender=in.nextLine();
		System.out.println("Enter your User Name");
		String userName=in.nextLine();
		System.out.println("Enter your password");
		String password=in.nextLine();
		
		User user=new User();
		user.setFirstnme(firstName);
		user.setLastname(lastName);
		user.setUsername(userName);
		user.setPassword(password);
		user.setGender(gender);
		user.setIsloggedin(false);
		System.out.println(user);
		UserDao userDao=new UserDao();
		userDao.registerUser(user);
		System.out.println("User Registered Successfully...");
		triggerAppForNonLoggedInUsers();
		in.close();
		
	}
	public void loginUser() {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your User Name");
		String userName=in.nextLine();
		System.out.println("Enter your password");
		String password=in.nextLine();
		UserDao userDao=new UserDao();
		boolean isloggedin=userDao.loginUser(userName,password);
		if(isloggedin) {
			System.out.println("User Logged in successfully");
			updateUserLoggedIn();
			TweetService tweetService=new TweetService();
			tweetService.triggerAppForLoggedInUsers();
		}else {
			System.out.println("Invalid Username or password");
			triggerAppForNonLoggedInUsers();
		}
		in.close();
		
	}
	
	public void updateUserLoggedIn() {
		UserDao userDao=new UserDao();
		userDao.updateUserLoggedInDB();
	}

}
