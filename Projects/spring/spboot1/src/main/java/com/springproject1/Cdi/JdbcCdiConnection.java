package com.springproject1.Cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import jakarta.inject.Named;

@Named
public class JdbcCdiConnection {

	public JdbcCdiConnection() {
		// TODO Auto-generated constructor stub
		System.out.println("JdbcCdi_con");
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("JdbcCdi_connection_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("JdbcCdi_connection_preDestroy");
	}
}

