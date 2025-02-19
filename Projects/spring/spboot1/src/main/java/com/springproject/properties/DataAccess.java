package com.springproject.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DataAccess {

	@Value("${url}")
	private String url;
	public DataAccess() {
	System.out.println("my data access layer");
	}

	public String getUrl() {
		return url;
	}
	
}
