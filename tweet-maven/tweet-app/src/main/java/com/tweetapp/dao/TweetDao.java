package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


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
}
