package com.microservices.currencyconversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CurrencyConversionController {

	static Logger logger=LoggerFactory.getLogger(CurrencyConversionController.class);
	
	static Function<Map.Entry<Object, Object>, String> getBytes=t -> t.toString()+"\n";
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	@Bulkhead(name="currency-conversion-rest",fallbackMethod = "ResponseForRest")
	public CurrencyConversion calculateCurrencyAmount(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info("into currency conversion rest");
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = forEntity.getBody();

		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getExchangeRate(),
				quantity, quantity.multiply(currencyConversion.getExchangeRate()),
				currencyConversion.getEnvironment() + " Rest template");

	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	@Bulkhead(name="currency-conversion-feign",fallbackMethod = "ResponseForFeign")
	public CurrencyConversion calculateCurrencyAmountWithFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info("into currency conversion feign");
		CurrencyConversion currencyConversion = proxy.retrieveExchangeRate(from, to);

		return 
		  new CurrencyConversion(currencyConversion.getId(), from,to,
		  currencyConversion.getExchangeRate(), quantity,
		  quantity.multiply(currencyConversion.getExchangeRate()),
		  currencyConversion.getEnvironment()+" feign") ;
		
	}

	public CurrencyConversion ResponseForFeign(
			Exception e) {
		logger.info("Currency-exchange fallback -> {}",e);
		return new CurrencyConversion();
	}
	
	public CurrencyConversion ResponseForRest(
			Exception e) {
		logger.info("Currency-exchange fallback -> {}",e);
		return new CurrencyConversion();
	}
		
}
