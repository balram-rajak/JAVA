package com.microservices.currencyexchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CurrencyExchangeService {

	static Logger logger=LoggerFactory.getLogger(CurrencyExchangeService.class);
	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@Bulkhead(name="currency-exchange",fallbackMethod = "ResponseForRest")
	public CurrencyExchange retrieveExchangeRate(@PathVariable String from, 
			@PathVariable String to) throws InterruptedException {
		
		CurrencyExchange currencyExchange = 
				repository.findByFromAndTo(from, to);
		logger.info("currency-exchange ");
		if (currencyExchange == null) {

			throw new RuntimeException("Unable to find data for " + from + "to " + to);
		}

		String property = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(property);
		Thread.sleep(10);
		return currencyExchange;
	}
	
	public CurrencyExchange ResponseForRest(Exception e) {
		logger.info("Currency-exchange fallback -> {}",e);
		return new CurrencyExchange();
	}

}
