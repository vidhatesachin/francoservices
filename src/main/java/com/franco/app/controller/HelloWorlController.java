package com.franco.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorlController {
	private final Logger logger = LoggerFactory.getLogger(HelloWorlController.class);
	
	@GetMapping(path = "hello/{name}")
	public ResponseEntity<String> sayHello(@PathVariable("name") String  name) {
		logger.info("inside sayHello method... received name : {}", name);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/json"))
				.body("Hello "+name);
	}

}
