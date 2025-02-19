package com.springproject.xml;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springproject1.Cdi.CdiDao;

//import com.springproject1.componentscan.ComponentDao;
//import com.springproject1.project1.Binarysearchalgo;
@Configuration
@ComponentScan("com.springproject1.Cdi")
public class XmlRegister {

	
	private static Logger logger=LoggerFactory.getLogger(XmlRegister.class);
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cont1=new AnnotationConfigApplicationContext(XmlRegister.class);
				
		
		
		CdiDao e1=cont1.getBean(CdiDao.class);
		CdiDao e2=cont1.getBean(CdiDao.class);
		
		System.out.println("///////////////");
		logger.trace("{}",e1);
		//logger.info("{}",e1.getJdbcCdiConnection());
		logger.info("{}",e2);
		//logger.info("{}",e2.getJdbcCdiConnection());
		cont1.close();
		
		
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("XmlRegister_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("XmlRegister_preDestroy");
	}

}
