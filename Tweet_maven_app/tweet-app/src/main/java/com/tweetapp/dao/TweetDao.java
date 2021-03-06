package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tweetapp.model.Tweet;

import com.tweetapp.service.TweetService;
import com.tweetapp.util.DBUtil;

public class TweetDao {

	public void postTweetInDb(Tweet tweet) {
		PreparedStatement preparedStatement = null;
		Connection conn = DBUtil.createNewDBconnection();
		String insertQueryStatement = "INSERT  INTO  tweet(tweet,userid)  VALUES  (?,?)";
		try {
			preparedStatement=conn.prepareStatement(insertQueryStatement);
			preparedStatement.setString(1, tweet.getTweet());
			preparedStatement.setInt(2, TweetService.useridGlobal);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	
	public List<Tweet> retreiveMyTweetsFromDb(int userid) {
		List<Tweet> tweetList=new ArrayList<Tweet>();
		String getQueryStatement = "SELECT tweet FROM tweet where userid=\""+userid+"\";";
		Connection conn = DBUtil.createNewDBconnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(getQueryStatement);
			while(resultSet.next()) {
				Tweet tweet=new Tweet();
				String tweetname=resultSet.getString("tweet");
				tweet.setTweet(tweetname);
				tweetList.add(tweet);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweetList;
	}
	
	public List<Tweet> retreiveAllTweetsFromDb(){
		List<Tweet> tweetList=new ArrayList<Tweet>();
		String getQueryStatement = "SELECT tweet FROM tweet;";
		Connection conn = DBUtil.createNewDBconnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(getQueryStatement);
			while(resultSet.next()) {
				Tweet tweet=new Tweet();
				String tweetname=resultSet.getString("tweet");
				tweet.setTweet(tweetname);
				tweetList.add(tweet);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweetList;
	}
	
	
}
