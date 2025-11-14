package com.balram.custom.config.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HeaderInterceptorAppConfig implements WebMvcConfigurer {

	@Autowired
	HeaderInterceptor headerInterceptor;

	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(headerInterceptor);
	   }

}
