package com.spring.controller;


import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String getWelcomeMessage() {
		System.out.println("Welcome chitty!!");
//		LOGGER.info("Welcome chitty!! (INFO)");
//		LOGGER.debug("Welcome chitty!! (DEBUG)");
//		LOGGER.trace("Welcome chitty!! (TRACE)");
//		LOGGER.warn("Welcome chitty!! (WARN)");
//		LOGGER.error("Welcome chitty!! (ERROR)");
		return "Welcome chitty!!";
	}
}
