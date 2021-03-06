package com.tweetapp.service;

import java.util.List;
import java.util.Scanner;

import com.tweetapp.dao.TweetDao;
import com.tweetapp.dao.UserDao;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.User;



public class TweetService {
	public static int useridGlobal;

	public  void triggerAppForLoggedInUsers() {
		System.out.println("Enter your choice");
		System.out.println("1. Post a tweet");
    	System.out.println("2. View my tweets");
    	System.out.println("3. view all tweets");
    	System.out.println("4. view all users");
    	System.out.println("5. Reset Password");
    	System.out.println("6. Logout");
    	Scanner in =new Scanner(System.in);
    	int a = in.nextInt();
    	UserService userService=new UserService();
    	switch (a) {
    		case 1:
    			postTweet();
    			break;
    		case 2:
    			retrieveMyTweets();
    			break;
    		case 3:
    			retrieveAllTweets();
    			break;
    		case 4:
    			retrieveAllUsers();
    			break;
    		case 5:
    			userService.resetPassword();
    			break;
    		case 6:
    			userService.logout();
    			break;
    		default:
    		    System.out.println("Invalid option");
    		    triggerAppForLoggedInUsers();
    			
    	}
    	in.close();
	}	
	
	public void postTweet() {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter your  Tweet");
		String tweetname=in.nextLine();
		Tweet tweet=new Tweet();
		tweet.setTweet(tweetname);
		tweet.setUserid(useridGlobal);
		TweetDao tweetDao=new TweetDao();
		tweetDao.postTweetInDb(tweet);
		System.out.println("Tweet posted Successfully");
		System.out.println("Press Enter for Enter in to Tweet MENU");
		in.nextLine();
		triggerAppForLoggedInUsers();
		in.close();
		
		
	}
	public void retrieveMyTweets() {
		Scanner in=new Scanner(System.in);
		TweetDao tweetDao=new TweetDao();
		List<Tweet> tweetlist=tweetDao.retreiveMyTweetsFromDb(TweetService.useridGlobal);
		if(tweetlist.isEmpty()) {
			System.out.println("No tweets found ");
			System.out.println("Press Enter for get back to Tweet MENU");
			in.nextLine();
			triggerAppForLoggedInUsers();
		}else {
			System.out.println("your tweets");
			int count=1;
			for(Tweet tweet:tweetlist) {
				System.out.println(count+" "+tweet.getTweet());
				count++;
			}
			System.out.println("Press Enter for get back to Tweet MENU");
			in.nextLine();
			triggerAppForLoggedInUsers();
			in.close();
		}
	}
	
	public void retrieveAllTweets() {
		Scanner in=new Scanner(System.in);
		TweetDao tweetDao=new TweetDao();
		List<Tweet> tweetlist=tweetDao.retreiveAllTweetsFromDb();
		if(tweetlist.isEmpty()) {
			System.out.println("No tweets found ");
			System.out.println("Press Enter for get back to Tweet MENU");
			in.nextLine();
			triggerAppForLoggedInUsers();
		}else {
			System.out.println("All tweets");
			int count=1;
			for(Tweet tweet:tweetlist) {
				System.out.println(count+". "+tweet.getTweet());
				count++;
			}
			System.out.println("Press Enter for get back to Tweet MENU");
			in.nextLine();
			triggerAppForLoggedInUsers();
			in.close();
		}
		
	}
	
	public void retrieveAllUsers() {
		Scanner in=new Scanner(System.in);
		UserDao userDao=new UserDao();
		List<User> userList=userDao.retreiveAllUsersFromDb();
		if(userList.isEmpty()) {
			System.out.println("No users found ");
			System.out.println("Press Enter for get back to Tweet MENU");
			in.nextLine();
			triggerAppForLoggedInUsers();
		}else {
			System.out.println("All users");
			int count=1;
			for(User user:userList) {
				System.out.println(count+". First name: "+user.getFirstnme()+", Last name: "+user.getLastname()+", gender: "+user.getGender());
				count++;
			}
			System.out.println("Press Enter for get back to Tweet MENU");
			in.nextLine();
			triggerAppForLoggedInUsers();
			in.close();
		}
		
	}
	
	
	

}
