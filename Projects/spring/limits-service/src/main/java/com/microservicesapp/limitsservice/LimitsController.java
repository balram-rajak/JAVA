package com.microservicesapp.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicesapp.limitsservice.bean.Limits;
import com.microservicesapp.limitsservice.configuration.LimitsServiceProperties;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitsServiceProperties properties;
	

	@GetMapping("/limits")
	public Limits retirieveLimits() {
		
		return new Limits(properties.getMinimum(),properties.getMaximum());
		
	}
}
