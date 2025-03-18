package com.microservices.currencyexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;


@RestController
public class CircuitBreakerController {

	Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api",fallbackMethod = "hardcodeResponse")
	//@CircuitBreaker(name = "default",fallbackMethod="hardcodeResponse")
	//@RateLimiter(name="default",fallbackMethod="hardcodeResponse")
	@Bulkhead(name="sample-api",fallbackMethod="hardcodeResponse")
	public String sampleApi() {
		logger.info("sample-api called");
		
		  ResponseEntity<String> response= new RestTemplate()
		  .getForEntity("http://localhost:8080/limits", String.class); return
		  response.getBody();
		 
		//return "Sample-api";
	}
	
	@GetMapping("/sample-api/con")
	@Bulkhead(name="con",fallbackMethod="ResponseForCon")
	public String sample() throws InterruptedException {
		
		logger.info("con called");
		Thread.sleep(50);
		return "Sample test for bulhead";
	}
	
	public String ResponseForCon(Exception e) {
		logger.info("Con get blocked");
		return "fallback- not allowed this many calls";
	}
	
	public String hardcodeResponse(Exception e) {
		logger.info("in open state");
		return "fallback- due to failure in reching out the resource";
	}
	
	
}
