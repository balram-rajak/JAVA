package com.springproject1.project1.scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springproject.xml.XmlEmployeeDao;

//import com.springproject1.componentscan.ComponentDao;
//import com.springproject1.project1.Binarysearchalgo;



public class Register {

	
	private static Logger logger=LoggerFactory.getLogger(Register.class);
	public static void main(String[] args) {
		ClassPathXmlApplicationContext cont1=
				new ClassPathXmlApplicationContext("Spring-Context.xml");
				
		
		XmlEmployeeDao e1=cont1.getBean(XmlEmployeeDao.class);
		//Binarysearchalgo b1=cont1.getBean(Binarysearchalgo.class);
		XmlEmployeeDao e2=cont1.getBean(XmlEmployeeDao.class);
		
		System.out.println("///////////////");
		System.out.println(e1);
		logger.info("{}",e1);
		logger.info("{}",e1.getXmlJdbcconnection());
		logger.info("{}",e2);
		logger.info("{}",e2.getXmlJdbcconnection());
		logger.info("Beans loaded {}",(Object)cont1.getBeanDefinitionNames());
		cont1.close();
		
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("project1appscope_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("project1appscope_preDestroy");
	}

}
