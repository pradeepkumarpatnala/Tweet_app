package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.dao.TweetDao;
import com.tweetapp.model.Tweet;



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
    	
    	switch (a) {
    		case 1:
    			postTweet();
    			break;
    		case 2:
    		//	retrieveMyTweets();
    			break;
    		case 3:
    			System.out.println("3. password");
    			break;
    		case 4:
    			System.out.println("3. password");
    			break;
    		case 5:
    			System.out.println("3. password");
    			break;
    		case 6:
    			System.out.println("3. password");
    			break;
    		default:
    		    System.out.println("Invalid option");
    			
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
		triggerAppForLoggedInUsers();
		in.close();
		
		
	}
	

}
