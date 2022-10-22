package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Users;
import com.spring.service.CustomService;

@RestController
public class CustomController {

	@Autowired
	CustomService objService;
	
	@GetMapping("/getAllUsers")
	public List<Users> getUsers(){
		return objService.getUsers();
	}
	
	@PostMapping("/saveUser")
	public Users addUser(@RequestBody Users objUser) {
		return objService.addUser(objUser);
	}
	
	@DeleteMapping("/removeUser")
	public void deleteUser(@RequestBody Users objUser) {
		objService.deleteUser(objUser);
	}
	
	@GetMapping("/findUserByName/{name}")
	public Users findUserByName(@PathVariable String name) {
		return objService.findUserByName(name);
	}
}
