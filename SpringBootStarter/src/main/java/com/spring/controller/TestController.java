package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pojo.EmployeesPOJO;

@RestController
public class TestController {
	
	@Autowired
	EmployeesPOJO objemployees;
	
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String getTestMessage() {
		return "Welcome to first SPring Boot app";
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
    public EmployeesPOJO getEmployees() {
    	return objemployees;
    }
	
	@RequestMapping(value="/employeesUpdate", method=RequestMethod.POST)
    public EmployeesPOJO insertEmployees(@RequestBody EmployeesPOJO objEmployeesPOJO) {
        System.out.println("objEmployeesPOJO" + objEmployeesPOJO);
    	return objemployees;
    }
}
