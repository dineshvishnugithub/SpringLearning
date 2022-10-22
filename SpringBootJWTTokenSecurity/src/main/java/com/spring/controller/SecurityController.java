package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.CustomAuthRequest;
import com.spring.util.JwtUtil;

@RestController
public class SecurityController {
	
	@Autowired
	JwtUtil objJwtUtil;
	@Autowired
	AuthenticationManager objAuthenticationManager;
	
	@GetMapping("/welcome")
	public String getTestMessage() {
		return "Welcome to JWT Security page";
	}
	
	@PostMapping("/generateToken")
	public String generateToken(@RequestBody CustomAuthRequest objCustomAuthRequest) throws Exception {
        try {
        	objAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(objCustomAuthRequest.getUserName(), objCustomAuthRequest.getPassword()));
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return objJwtUtil.generateToken(objCustomAuthRequest.getUserName());
	}

}
