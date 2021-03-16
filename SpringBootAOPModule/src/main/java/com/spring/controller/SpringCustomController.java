package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pojo.EmployeePOJO;
import com.spring.service.SpringCustomService;

@RestController
public class SpringCustomController {
	
	@Autowired
	SpringCustomService springService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String getTest() {
		System.out.println("Inside controller");
		return "test controller";
	}
	
	@RequestMapping(value="/employees/create", method=RequestMethod.GET)
	public EmployeePOJO createEmployee(@RequestParam("name") String name, @RequestParam(required=true, name = "empId") String empId) {
		System.out.println("Inside controller:: createEmployee");
		return springService.createEmployee(name, empId);
	}
	
	@RequestMapping(value="/employees/create1", method=RequestMethod.GET)
	public EmployeePOJO createEmployee1(@RequestParam(required=false, name = "name") String name, @RequestParam(required=true, name = "empId") String empId) {
		System.out.println("Inside controller:: createEmployee1 - checking for required=false, as by default required is true");
		return springService.createEmployee(name, empId);
	}

	@RequestMapping(value="/employees/remove", method=RequestMethod.GET)
	public String removeEmployee(@RequestParam(required=true, name = "empId") String empId) {
		System.out.println("Inside controller:: removeEmployee");
		return springService.deleteEmployee(empId);
	}
	
	@RequestMapping(value="/employees/update/{name}", method=RequestMethod.GET)
	public String updateEmployee(@PathVariable("name") String name) {
		System.out.println("Inside controller:: updateEmployee - using path variable");
		return springService.updateEmployee(name);
	}
	
	@RequestMapping(value="/employees/update/{name}/{empId}", method=RequestMethod.GET)
	public String updateEmployee(@PathVariable("name") String name, @PathVariable("empId") String empId) {
		System.out.println("Inside controller:: updateEmployee - using 2 path variable");
		System.out.println("Inside controller:: updateEmployee:: name:: " + name);
		System.out.println("Inside controller:: updateEmployee:: empId:: " + empId);
		return springService.updateEmployee(name);
	}
}
