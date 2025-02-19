package com.springproject.properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import jakarta.inject.Inject;

@Service
public class BuisnessService {

	@Inject
	DataAccess jdbcconnection;


	public DataAccess getDataAccess() {
		return jdbcconnection;
	}

	public void setDataAccess(DataAccess jdbcconnection) {
		this.jdbcconnection = jdbcconnection;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("BuisnessService_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("BuisnessService_preDestroy");
	}

	
	
}

