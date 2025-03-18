package com.springproject.xml;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Component
public class XmlEmployeeDao {
	
@Inject
	XmlJdbcconnection jdbcconnection;

	public XmlJdbcconnection getXmlJdbcconnection() {
		return jdbcconnection;
	}

	public void setXmlJdbcconnection(XmlJdbcconnection jdbcconnection) {
		this.jdbcconnection = jdbcconnection;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("XmlEmployeeDao_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("XmlEmployeeDao_preDestroy");
	}

	
	
}
