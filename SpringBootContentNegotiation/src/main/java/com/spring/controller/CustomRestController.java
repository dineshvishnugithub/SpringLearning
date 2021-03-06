package com.spring.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.Employee;

@RestController
public class CustomRestController {
	
	@RequestMapping(value="/getEmpDetailsXML", consumes="application/xml", produces="application/json", method=RequestMethod.GET)
	public Employee getEmployees1(@RequestBody Employee objEmp1){
		System.out.println("objEmp1 id:: " + objEmp1.getEmpId());
		System.out.println("objEmp1 name:: " + objEmp1.getName());
		System.out.println("objEmp1 orgName:: " + objEmp1.getOrgName());
		Employee objEmployee = new Employee();
		objEmployee.setEmpId(101);
		objEmployee.setName("Dinesh");
		objEmployee.setOrgName("Crimsonlogic");
		
		return objEmployee;
	}
	
}
