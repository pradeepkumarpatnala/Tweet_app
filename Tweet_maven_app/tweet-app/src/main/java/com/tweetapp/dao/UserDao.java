/**
 * 
 */
package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
	
	public List<User> retreiveAllUsersFromDb(){
		List<User> userList=new ArrayList<User>();
		
		String getQueryStatement = "SELECT firstname,lastname,gender FROM user;";
		Connection conn = DBUtil.createNewDBconnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(getQueryStatement);
			while(resultSet.next()) {
				User user=new User();
				String firstName=resultSet.getString("firstname");
				String lastName=resultSet.getString("lastname");
				String gender=resultSet.getString("gender");
				user.setFirstnme(firstName);
				user.setLastname(lastName);
				user.setGender(gender);
				userList.add(user);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	public void logoutFromDb() {
		PreparedStatement preparedStatement = null;
		Connection conn = DBUtil.createNewDBconnection();
		String updateQueryStatement = "update user set isloggedin=? where id=?";
		try {
			preparedStatement=conn.prepareStatement(updateQueryStatement);
			preparedStatement.setBoolean(1, false);
			preparedStatement.setInt(2, TweetService.useridGlobal);
			preparedStatement.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkEmailExists(String username) {
		String getQueryStatement = "SELECT id FROM user where username=\""+username+"\";";
		Connection conn = DBUtil.createNewDBconnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(getQueryStatement);
			if(!resultSet.next()) {
					conn.close();
					return false;
			}else {
					conn.close();
					return true;
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void updatePasswordInDb(String username,String password) {
	
			PreparedStatement preparedStatement = null;
			Connection conn = DBUtil.createNewDBconnection();
			String updateQueryStatement = "update user set password=? where username=?";
			try {
				preparedStatement=conn.prepareStatement(updateQueryStatement);
				preparedStatement.setString(1, password);
				preparedStatement.setString(2, username);
				preparedStatement.executeUpdate();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void resetPasswordInDb(String password) {
		PreparedStatement preparedStatement = null;
		Connection conn = DBUtil.createNewDBconnection();
		String updateQueryStatement = "update user set password=? where id=?";
		try {
			preparedStatement=conn.prepareStatement(updateQueryStatement);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, TweetService.useridGlobal);
			preparedStatement.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
