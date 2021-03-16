package com.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producerAPI")
public class SpringProducerController {
	
	@RequestMapping(value="/rest-with-header", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getEmployeewihtHeaderName(@RequestHeader("employeeName") String employeeName) {
		System.out.println("SpringProducerController: getEmployeewihtHeaderName:: employeeName::: " + employeeName);
		return employeeName;		
	}

}
