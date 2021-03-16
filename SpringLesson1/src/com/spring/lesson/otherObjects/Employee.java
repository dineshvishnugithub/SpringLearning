package com.spring.lesson.otherObjects;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
   private String name;
   private int empId;
   @Autowired
   @Qualifier("dateutil1")
   private Date doj;
   @Autowired
   @Qualifier("bigdecimal1")
   private BigDecimal salary;   
   
public Employee(String name, int empId, Date doj, BigDecimal salary) {
	super();
	this.name = name;
	this.empId = empId;
	this.doj = doj;
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [name=" + name + ", empId=" + empId + ", doj=" + doj + ", salary=" + salary + "]";
}
   
   //inject date and bigdecimal objects as a bean(ref)
   
}
