package com.tweetappdynamodb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetappdynamodb.model.Tweet;
import com.tweetappdynamodb.repository.TweetRepository;



@Service
public class TweetService {
	@Autowired
	private TweetRepository tweetRepository;
	
	
	public List<Tweet> getAllTweets(){
		List<Tweet> tweets = (List<Tweet>) tweetRepository.findAll();
    	List<Tweet> tweetList = new ArrayList<Tweet>(tweets);
		return tweetList;
	}
	
	public void postTweet(Tweet tweet){
		tweetRepository.save(tweet);
	}
	
	public void updateTweet(Tweet tweet) {
		tweetRepository.save(tweet);
	}
	
	public void deleteTweet(String id) {
		tweetRepository.deleteById(id);
	}
	
	public Tweet getById(String id) {
		return tweetRepository.findById(id).get();
	}
	
	public List<Tweet> getAllTweetsBYUser(String userId){
		return tweetRepository.findTweetByUserid(userId);
	}
	
	
}	

