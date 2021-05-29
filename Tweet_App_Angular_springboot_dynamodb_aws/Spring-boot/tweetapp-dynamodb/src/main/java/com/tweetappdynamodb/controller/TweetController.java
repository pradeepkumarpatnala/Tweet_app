package com.tweetappdynamodb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.tweetappdynamodb.model.Tweet;
import com.tweetappdynamodb.model.User;
import com.tweetappdynamodb.repository.TweetRepository;
import com.tweetappdynamodb.repository.UserRepository;
import com.tweetappdynamodb.service.TweetService;
import com.tweetappdynamodb.service.UserService;

@RestController
@RequestMapping("/api/v1.0/tweetService")
public class TweetController {
	
	
	@Autowired
	private TweetService tweetService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllTweets")
	public List<Tweet> getAllTweets(){
		return tweetService.getAllTweets();
	}
	
	@PostMapping("/add")
	public void postTweet(@RequestBody Tweet tweet) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		User user=userService.getUserById(tweet.getUserid());
		tweet.setFirstname(user.getFirstname());
		tweet.setDate(date);
		tweetService.postTweet(tweet);
	}
	
	@GetMapping("getTweetById")
	public Tweet getTweetById(@RequestParam String id){
		return tweetService.getById(id);
	}
	
	@PutMapping("/update")
	public void updateTweet(@RequestBody Tweet tweet) {
		Tweet newTweet=tweetService.getById(tweet.getId());
		tweet.setFirstname(newTweet.getFirstname());
		tweet.setDate(newTweet.getDate());
		tweet.setLikes(newTweet.getLikes());
		tweet.setReply(newTweet.getReply());
		tweetService.updateTweet(tweet);
	}
	
	@DeleteMapping("delete")
	public void deleteTweet(@RequestParam String id) {
		tweetService.deleteTweet(id);
	}
	
	@PutMapping("like")
	public void likeTweet(@RequestParam String id) {
		Tweet tweet=tweetService.getById(id);
		tweet.setLikes(tweet.getLikes()+1);
		tweetService.updateTweet(tweet);
	}
	
	@PutMapping("reply")
	public void replyTweet(@RequestParam String id,@RequestParam String reply) {
		Tweet tweet=tweetService.getById(id);
		List<String> replies=tweet.getReply();
		replies.add(reply);
		tweet.setReply(replies);
		tweetService.updateTweet(tweet);
	}
	
	@GetMapping("/getAllTweetsOfUser")
	public List<Tweet> getTweetsByUser(@RequestParam String userId){
		return tweetService.getAllTweetsBYUser(userId);
	}
}
