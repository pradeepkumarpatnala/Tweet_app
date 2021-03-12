package com.tweetapp.model;

public class User {

	private String username;
	private String firstnme;
	private String lastname;
	private String password;
	private String gender;
	private boolean isloggedin;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String firstnme, String lastname, String password, String gender, boolean isloggedin) {
		super();
		this.username = username;
		this.firstnme = firstnme;
		this.lastname = lastname;
		this.password = password;
		this.gender = gender;
		this.isloggedin = isloggedin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstnme() {
		return firstnme;
	}
	public void setFirstnme(String firstnme) {
		this.firstnme = firstnme;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isIsloggedin() {
		return isloggedin;
	}
	public void setIsloggedin(boolean isloggedin) {
		this.isloggedin = isloggedin;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", firstnme=" + firstnme + ", lastname=" + lastname + ", password="
				+ password + ", gender=" + gender + ", isloggedin=" + isloggedin + "]";
	}
	

}
