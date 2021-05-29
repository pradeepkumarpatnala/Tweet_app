package com.tweetappdynamodb.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tweetappdynamodb.model.User;





@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
	List<User> findUserByUsernameAndPassword(String username,String password);
	List<User> findUserByUsername(String Username);
	
}
