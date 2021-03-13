/**
 * 
 */
package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.tweetapp.model.User;
import com.tweetapp.service.TweetService;
import com.tweetapp.util.DBUtil;

/**
 * @author Pradeep
 *
 */
public class UserDao {
	
	public void  registerUser(User user) {
		PreparedStatement preparedStatement = null;
		Connection conn = DBUtil.createNewDBconnection();
		String insertQueryStatement = "INSERT  INTO  user(username,firstname,lastname,password,gender,isloggedin)  VALUES  (?,?,?,?,?,?)";
		try {
			preparedStatement=conn.prepareStatement(insertQueryStatement);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getFirstnme());
			preparedStatement.setString(3, user.getLastname());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getGender());
			preparedStatement.setBoolean(6, user.isIsloggedin());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e);
		}
		
	}
	
	public boolean loginUser(String username,String password) {
		String getQueryStatement = "SELECT id FROM user where username=\""+username+"\" and password=\""+password+"\";";
		Connection conn = DBUtil.createNewDBconnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(getQueryStatement);
			if(!resultSet.next()) {
					conn.close();
					return false;
			}else {
					int id = resultSet.getInt("id");
					TweetService.useridGlobal=id;
					conn.close();
					return true;
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateUserLoggedInDB() {
		PreparedStatement preparedStatement = null;
		Connection conn = DBUtil.createNewDBconnection();
		String updateQueryStatement = "update user set isloggedin=? where id=?";
		try {
			preparedStatement=conn.prepareStatement(updateQueryStatement);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, TweetService.useridGlobal);
			preparedStatement.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
