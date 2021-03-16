package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDao;
import java.util.List;

import javax.transaction.Transactional;

import com.spring.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImplementation implements EmployeeService{
	
    @Autowired
    private EmployeeDao dao;

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }
 
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }
 
    public void deleteEmployeeByEmployeeId(int empId) {
        dao.deleteEmployeeByEmployeeId(empId);
    }
 
    public Employee findByEmployeeId(int empId) {
        return dao.findByEmployeeId(empId);
    }
 
    public void updateEmployee(Employee employee){
        dao.updateEmployee(employee);
    }

}
