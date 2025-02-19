package com.springproject.xml;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import jakarta.inject.Named;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class XmlJdbcconnection {

 public XmlJdbcconnection() {
		
	
		System.out.println("Jdbcconnection");
	}
 @PostConstruct
	public void postConstruct() {
		System.out.println("XmlJdbcconnection_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("XmlJdbcconnection_preDestroy");
	}

}
