package com.spring_mvc.springapplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppContext {

	Environment environment;
	LocalSessionFactoryBean sessionFactory;
	
	
DriverManagerDataSource datasource= new DriverManagerDataSource();

void test() {
	
}

}
