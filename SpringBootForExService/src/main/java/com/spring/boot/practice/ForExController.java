package com.spring.boot.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForExController {
	@Autowired
	private Environment environment;

	@Autowired
	private ForExRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ForexValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		ForexValue forexValue = repository.findByFromAndTo(from, to);

		forexValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		return forexValue;
	}
}
