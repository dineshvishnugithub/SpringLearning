package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.DataRepositoryInterface;
import com.spring.entity.Employees;
import com.spring.exception.RecordNotFoundException;

@Service
public class DataService {
    
	@Autowired
	DataRepositoryInterface dataRepositoryInterface;
	
	public List<Employees> findAllEmployees() {
		List<Employees> empolyeesList = dataRepositoryInterface.findAll();
		if(null!=empolyeesList) {
			return empolyeesList;
		} else {
			return new ArrayList<Employees>();
		}
	}
	
	public Employees findByEmployeeId(int empId) throws RecordNotFoundException{
		Optional<Employees> objEmployee = dataRepositoryInterface.findById(empId);
		if(objEmployee.isPresent()) {
			return objEmployee.get();
		} else {
			throw new RecordNotFoundException("Record not found for empId :: " + empId);
		}
	}

	public void createUpdateEmployees(Employees objEmployee) {
		Optional<Employees> objEmployeeDB = dataRepositoryInterface.findById(objEmployee.getEmployeeId());
		if(objEmployeeDB.isPresent()) {
			//update
			dataRepositoryInterface.save(objEmployee);
		} else {
			//create
			dataRepositoryInterface.save(objEmployee);
		}
	}

	public void deleteEmployee(int empId) {
		Optional<Employees> objEmployeeDB = dataRepositoryInterface.findById(empId);
		if(objEmployeeDB.isPresent()) {
			//delete
			dataRepositoryInterface.deleteById(empId);
		} else {
			//record not found
			throw new RecordNotFoundException("Record not found for empId :: " + empId);
		}
		
	}

}
