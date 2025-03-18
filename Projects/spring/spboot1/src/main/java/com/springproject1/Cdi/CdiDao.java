package com.springproject1.Cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class CdiDao {

@Inject
private JdbcCdiConnection jdbcconnection;

	public JdbcCdiConnection getJdbcCdiConnection() {
		return jdbcconnection;
	}

	public void setJdbcCdiConnection(JdbcCdiConnection jdbcconnection) {
		this.jdbcconnection = jdbcconnection;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("CdiDao_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("CdiDao_preDestroy");
	}
	
}
