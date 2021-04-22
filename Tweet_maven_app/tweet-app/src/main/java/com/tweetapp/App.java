package com.tweetapp;

import java.util.Scanner;

import com.tweetapp.dao.UserDao;
import com.tweetapp.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserService userService=new UserService();
    	userService.triggerAppForNonLoggedInUsers();
    	
    }
}
