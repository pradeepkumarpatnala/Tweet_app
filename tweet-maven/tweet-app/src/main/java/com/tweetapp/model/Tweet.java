package com.tweetapp.model;

public class Tweet {

	private String tweet;
	private int userid;
	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tweet(String tweet, int userid) {
		super();
		this.tweet = tweet;
		this.userid = userid;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Tweet [tweet=" + tweet + ", userid=" + userid + "]";
	}
	
	

}
