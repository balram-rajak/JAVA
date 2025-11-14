package com;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * MySQL database properties loader.
 * Reads database configuration from mysql.properties file.
 * 
 * @author Balram Rajak
 */
public class Mysql_Properties {
	/** Database JDBC URL */
	public String url;
	
	/** Database username */
	private String uname;
	
	/** Database password */
	private String validation_key;

	/**
	 * Reads MySQL properties from the configuration file.
	 * Loads JDBC URL, username, and password.
	 */
	private void read_property() {
		
		Properties pr=new Properties();
		
		try(FileInputStream fin=new FileInputStream("/Users/rakesh/eclipse-workspace/Loginportal/src/main/java/resources/mysql.properties")){
			
			pr.load(fin);
			url=pr.getProperty("jdbc-url");
			uname=pr.getProperty("uname");
			validation_key=pr.getProperty("validation");
			
		}
		catch(Exception e) {
			Logger.send_log(e.toString());
		}
		
	}

	/**
	 * Gets the MySQL JDBC URL.
	 * 
	 * @return JDBC connection URL
	 */
	public String get_jdbc_mysql_url() {
		return url;
	}
	
	/**
	 * Gets the database username.
	 * 
	 * @return Database username
	 */
	public String get_jdbc_uname() {
		return uname;
	}
	
	/**
	 * Gets the database password.
	 * 
	 * @return Database password
	 */
	public String get_jdbc_validation() {
		return validation_key;
	}
	
	/**
	 * Constructor that initializes properties by reading from configuration file.
	 */
	public Mysql_Properties() {
		read_property();
		
	}
}
