package com.tweetapp.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    			loginUser();
    			break;
    		case 3:
    			forgotPassword();
    			break;
    		default:
    		    System.out.println("Invalid option");
    		    triggerAppForNonLoggedInUsers();
    			
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
		Boolean isValidEmail=validateEmail(userName);
		if(isValidEmail) {
			UserDao userDao=new UserDao();
			Boolean isEmailExists=userDao.checkEmailExists(userName);
			if(isEmailExists) {
				System.out.println("username already exists please try with new username");
			}else {
				userDao.registerUser(user);
				System.out.println("User Registered Successfully...");
			}
		}else {
			System.out.println("Invalid username");
		}
		System.out.println("Press Enter for Main MENU");
		in.nextLine();
		triggerAppForNonLoggedInUsers();
		in.close();
		
	}
	
	static String emailRegex = "^(.+)@(.+)$";
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(emailRegex);

	public static boolean validateEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
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
			System.out.println("Press Enter for Tweet MENU");
			in.nextLine();
			tweetService.triggerAppForLoggedInUsers();
		}else {
			System.out.println("Invalid Username or password");
			System.out.println("Press Enter for Main MENU");
			in.nextLine();
			triggerAppForNonLoggedInUsers();
		}
		in.close();
		
	}
	
	public void updateUserLoggedIn() {
		UserDao userDao=new UserDao();
		userDao.updateUserLoggedInDB();
	}
	
	public void logout() {
		Scanner in=new Scanner(System.in);
		UserDao userDao=new UserDao();
		userDao.logoutFromDb();
		System.out.println("User Logged out successfully");
		System.out.println("Press Enter for Main MENU");
		in.nextLine();
		triggerAppForNonLoggedInUsers();
		in.close();
	}
	
	public void forgotPassword() {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your User Name");
		String userName=in.nextLine();
		UserDao userDao=new UserDao();
		Boolean isEmailExists=userDao.checkEmailExists(userName);
		if(isEmailExists) {
			System.out.println("Email was validated");
			System.out.println("Enter your new password");
			String password=in.nextLine();
			userDao.updatePasswordInDb(userName,password);
			System.out.println("Password updated successfully");		
		}else {
			System.out.println("Invalid email");
		}
		System.out.println("Press Enter for Main MENU");
		in.nextLine();
		triggerAppForNonLoggedInUsers();
		in.close();
		
	}
	
	public void resetPassword() {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter new password");
		String password=in.nextLine();
		UserDao userDao=new UserDao();
		userDao.resetPasswordInDb(password);
		System.out.println("password resetted Successfully");
		System.out.println("Press Enter for Enter in to Tweet MENU");
		in.nextLine();
		TweetService tweetService=new TweetService();
		tweetService.triggerAppForLoggedInUsers();
		in.close();
	}
}
