package com;

import java.io.FileInputStream;
import java.util.Properties;


public class Mysql_Properties {
public String url;
private String uname;
private String validation_key;

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

	 public String get_jdbc_mysql_url() {
		return url;
	}
	
	public String get_jdbc_uname() {
		return uname;
	}
	
	public String get_jdbc_validation() {
		return validation_key;
	}
	
	public Mysql_Properties() {
		read_property();
		
	}
}
