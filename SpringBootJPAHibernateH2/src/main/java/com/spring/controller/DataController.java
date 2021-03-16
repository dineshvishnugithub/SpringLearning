package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.entity.Employees;
import com.spring.exception.RecordNotFoundException;
import com.spring.service.DataService;

@RestController
@RequestMapping("/h2test")
@CrossOrigin("*")
public class DataController {
	
	@Autowired
	public DataService objDataService;
	
	@RequestMapping(value="/listEmployees", method=RequestMethod.GET)
	public ResponseEntity<List<Employees>> getAllEmployeesData() {
		System.out.println("Inside Data controller:: ");
		List<Employees> objEmployeesList = objDataService.findAllEmployees();
		return new ResponseEntity<List<Employees>>(objEmployeesList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{empId}", method=RequestMethod.GET)
	public ResponseEntity<Object> findByEmployeeId(@PathVariable int empId) {
		System.out.println("Inside Data controller:: findByEmployeeId: " + empId);
		try {
			Employees objEmployees = objDataService.findByEmployeeId(empId);
			return new ResponseEntity<Object>(objEmployees, new HttpHeaders(), HttpStatus.OK);
		} catch(RecordNotFoundException re) {
			return new ResponseEntity<Object>("Record not found", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST)
	public ResponseEntity<Object> createUpdateEmployees(@RequestBody Employees objEmployee) {
		System.out.println("Inside Data controller:: findByEmployeeId: " + objEmployee.getEmployeeId());
		try {
			objDataService.createUpdateEmployees(objEmployee);
			return new ResponseEntity<Object>("Record saved successfully", new HttpHeaders(), HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<Object>("Record not saved successfully", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.POST)
	public ResponseEntity<Object> deleteEmployee(@RequestParam String empId) {
		System.out.println("Inside Data controller:: findByEmployeeId: " + empId);
		try {
			objDataService.deleteEmployee(Integer.parseInt(empId));
			return new ResponseEntity<Object>("Record deleted successfully", new HttpHeaders(), HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity<Object>("Record not deleted successfully", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
}
