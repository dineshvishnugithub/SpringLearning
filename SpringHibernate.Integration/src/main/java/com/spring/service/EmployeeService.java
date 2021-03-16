package com.spring.service;

import java.util.List;
import com.spring.model.Employee;

public interface EmployeeService {
	
    void saveEmployee(Employee employee);
    
    List<Employee> findAllEmployees();
 
    void deleteEmployeeByEmployeeId(int empId);
 
    Employee findByEmployeeId(int empId);
 
    void updateEmployee(Employee employee);

}
