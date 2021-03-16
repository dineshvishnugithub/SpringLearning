package com.spring.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.spring.employee.Employee;

@Controller
public class CustomController {
   
	@RequestMapping(value="/getEmpDetails", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployees(){
		Employee objEmployee = new Employee();
		objEmployee.setEmpId(101);
		objEmployee.setName("Dinesh");
		objEmployee.setOrgName("Crimsonlogic");
		
		return new ResponseEntity<Employee>(objEmployee, HttpStatus.ACCEPTED);
	}
	
    //if using @controller, have to use @ResponseBody as return type , if using produces=json	
	@RequestMapping(value="/getEmpDetailsXML1", consumes="application/xml", produces="application/json", method=RequestMethod.GET)
	public @ResponseBody Employee getEmployees2(@RequestBody Employee objEmp1){
		System.out.println("objEmp1 id:: " + objEmp1.getEmpId());
		System.out.println("objEmp1 name:: " + objEmp1.getName());
		System.out.println("objEmp1 orgName:: " + objEmp1.getOrgName());
		Employee objEmployee = new Employee();
		objEmployee.setEmpId(103);
		objEmployee.setName("Dinesh3");
		objEmployee.setOrgName("Crimsonlogic3");
		
		return objEmployee;
	}
}
