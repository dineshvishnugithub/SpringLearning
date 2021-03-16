package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

public interface EmployeeDao {

    void saveEmployee(Employee employee);
    
    List<Employee> findAllEmployees();
     
    void deleteEmployeeByEmployeeId(int empId);
     
    Employee findByEmployeeId(int empId);
     
    void updateEmployee(Employee employee);
}
