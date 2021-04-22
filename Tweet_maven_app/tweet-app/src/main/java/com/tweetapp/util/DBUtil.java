package com.tweetapp.util;



 
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class DBUtil {
	private static final String DB_DRIVER_CLASS="driver.class.name";
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	private static final String DB_URL ="db.url";
	
	private static Connection connection = null;
	private static Properties properties = null;
	
	
	
	
	@SuppressWarnings("finally")
	public static Connection createNewDBconnection() {
		try  {	
			
			properties = new Properties();
			properties.load(new FileInputStream("src/main/java/com/tweetapp/util/db.properties"));
			Class.forName(properties.getProperty(DB_DRIVER_CLASS));
			connection = DriverManager.getConnection(properties.getProperty(DB_URL),properties.getProperty(DB_USERNAME) , properties.getProperty(DB_PASSWORD) );
		} catch (Exception e) {
			System.out.println("Cannot create database connection");
			e.printStackTrace();
		} finally {
			return connection;	
		}		
	}
}



