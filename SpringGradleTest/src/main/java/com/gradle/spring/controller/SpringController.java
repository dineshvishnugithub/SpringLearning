package com.gradle.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
	
	@RequestMapping(value="/testGraddle", method=RequestMethod.GET)
	public String testGraddleAppn(@RequestParam(name="obj") String argObj) {
		return "Gradle is success. :: " + argObj;
	}

}
