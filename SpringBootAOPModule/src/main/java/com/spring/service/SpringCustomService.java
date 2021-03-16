package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.pojo.EmployeePOJO;

@Service
public class SpringCustomService {
	
	public EmployeePOJO createEmployee(String name, String empId) {
		System.out.println("SpringCustomService Inside createEmployee:: name, empId::  "+ name + " , " + empId);
		EmployeePOJO objEmployeePOJO = new EmployeePOJO();
		objEmployeePOJO.setName(name);
		objEmployeePOJO.setEmpId(Integer.parseInt(empId));
		
		return objEmployeePOJO;
	}
	
	public String deleteEmployee(String empId) {
		System.out.println("SpringCustomService Inside deleteEmployee:: empId::  "+ empId);
		
		return "Employeed ID:: " + empId + "is removed";
	}
	
	public String updateEmployee(String name) {
		System.out.println("SpringCustomService Inside updateEmployee:: name::  "+ name);
		
		return "Employeed name:: " + name + "is updated";
	}

}
