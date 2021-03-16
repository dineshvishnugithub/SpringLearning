package com.spring.tester;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.config.SpringConfiguration;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

public class SpringHibernateTester {
	
    public static void main(String args[]) {
	    AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
	    EmployeeService service = (EmployeeService) context.getBean("employeeService");
    
	    /*
	     * Create Employee1
	     */
	    Employee employee1 = new Employee();
	    employee1.setEmployeeId(507);
	    employee1.setFirstName("Dinesh3");
	    employee1.setLastName("Spring Hibernate Integ");
	    employee1.setEmail("d@k10.com");
	    employee1.setPhoneNumber("+9111111111");
	    employee1.setHireDate(new LocalDate());
	    employee1.setJobID("IT_PROG");
	    employee1.setSalary(new BigDecimal(30000.567));
	    employee1.setCommissionPct(new BigDecimal(0.567));
	    employee1.setManagerId(124);
	    employee1.setDepartmentId(50);

	    /*
	     * Persist Employees
	     */
//	    service.saveEmployee(employee1);

	    /*
	     * Get all employees list from database
	     */
//		 List<Employee> employees = service.findAllEmployees(); 
//		 for (Employee emp :employees) { 
//			 System.out.println(emp); 
//		 }
	 
	 
	    /*
	     * delete an employee
	     */
//	    service.deleteEmployeeByEmployeeId(504);

	    /*
	     * update an employee
	     */
		  Employee employee = service.findByEmployeeId(505); 
		  System.out.println(employee);
		  
		  employee.setSalary(new BigDecimal(2389.46)); 
		  service.updateEmployee(employee);
	 
		  context.close();
    
    }
}
