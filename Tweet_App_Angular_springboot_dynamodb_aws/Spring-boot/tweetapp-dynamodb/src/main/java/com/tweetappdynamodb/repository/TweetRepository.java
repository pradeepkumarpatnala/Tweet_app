package com.tweetappdynamodb.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetappdynamodb.model.Tweet;
import com.tweetappdynamodb.model.User;



@EnableScan
public interface TweetRepository extends CrudRepository<Tweet, String> {

	List<Tweet> findTweetByUserid(String userId);

}
