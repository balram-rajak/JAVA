package com.microservices.currencyconversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("${currencyExchangeUrl}")
	public CurrencyConversion retrieveExchangeRate(@PathVariable String from, 
			@PathVariable String to);
	
}
