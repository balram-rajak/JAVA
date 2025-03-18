package com.balram.custom.config.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(HeaderInterceptor.class);
	private static final String TRANSACTION_ID_HEADER = "transactionId";
	private static final String CLIENT_ID_HEADER = "clientId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		LOGGER.info("preHanlde Method in InterceptorConfiguration class");
		String transactionID = null;		
		String clientID = null;
		if (request.getHeader(TRANSACTION_ID_HEADER) != null) {
			transactionID = request.getHeader(TRANSACTION_ID_HEADER);				
		
		} else {
			transactionID = UUID.randomUUID().toString();
			response.setHeader(TRANSACTION_ID_HEADER, transactionID);
		}
		if(request.getHeader(CLIENT_ID_HEADER) != null) {
			clientID = request.getHeader(CLIENT_ID_HEADER);
		}		
		
		MDC.put(TRANSACTION_ID_HEADER,transactionID);
		MDC.put(CLIENT_ID_HEADER,clientID);
		LOGGER.info("setting header information");
		
		return true;
	}

}
