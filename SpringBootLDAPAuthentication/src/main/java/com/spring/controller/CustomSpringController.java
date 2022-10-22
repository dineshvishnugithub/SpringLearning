package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomSpringController {
	
	@GetMapping("/welcomeLDAP")
	public String getLDAPAuthenticatedMessage() {
		return "Welcome to LDAP Authenticated successfully page";
	}

}
