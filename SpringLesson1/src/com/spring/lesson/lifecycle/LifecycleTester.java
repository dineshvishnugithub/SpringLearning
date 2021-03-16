package com.spring.lesson.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTester {

   public static void main(String[] args) {
	 
	 System.out.println("Before XML loading");
	 ApplicationContext objXMLContext = new ClassPathXmlApplicationContext("lifecycle.xml");
	 System.out.println("After XML loading");
	 
	 CustomerLifeCycle objCustLifeCycle1 = (CustomerLifeCycle) objXMLContext.getBean("custlifeCycle1");
	 System.out.println("objCustLifeCycle1:: " + objCustLifeCycle1);
	 
	 CustomerLifeCycle objCustLifeCycle2 = (CustomerLifeCycle) objXMLContext.getBean("custlifeCycle2");
	 System.out.println("objCustLifeCycle2:: " + objCustLifeCycle2);
	 
	 EmployeesLifeCycle objEmpLifeCycle1 = (EmployeesLifeCycle) objXMLContext.getBean("emplifeCycle1");
	 System.out.println("objEmpLifeCycle1:: " + objEmpLifeCycle1);
	 
	 EmployeesLifeCycle objEmpLifeCycle2 = (EmployeesLifeCycle) objXMLContext.getBean("emplifeCycle2");
	 System.out.println("objEmpLifeCycle2:: " + objEmpLifeCycle2);
	 
	 System.out.println("Before individual Annotation loading");
	 ApplicationContext objCustAnnotContext = new AnnotationConfigApplicationContext(CustomerAnnotLifeCycleConfig.class);
	 System.out.println("After individual Annotation loading");
	 
	 CustomerAnnotLifecycle objCustAnnotLifeCycle1 = (CustomerAnnotLifecycle) objCustAnnotContext.getBean("customerAnnotLifeCycle");
	 System.out.println("objCustAnnotLifeCycle1:: " + objCustAnnotLifeCycle1);
	 
	 System.out.println("Before accumulated Annotation loading");
	 ApplicationContext objAnnotContext = new AnnotationConfigApplicationContext(LifeCycleAnnotConfig.class);
	 System.out.println("After accumulated Annotation loading");
	 
	 EmployeeAnnotLifecycle objEmpAnnotLifeCycle1 = (EmployeeAnnotLifecycle) objAnnotContext.getBean("employeeAnnotLifeCycle");
	 System.out.println("objEmpAnnotLifeCycle1:: " + objEmpAnnotLifeCycle1);
	
   }
}
