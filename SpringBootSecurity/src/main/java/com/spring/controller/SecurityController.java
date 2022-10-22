package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getUserRole() {
		return "user";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String getAdminRole() {
		return "admin";
	}
}
