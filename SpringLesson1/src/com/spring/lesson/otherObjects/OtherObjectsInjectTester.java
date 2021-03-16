package com.spring.lesson.otherObjects;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OtherObjectsInjectTester {
	
	public static void main(String[] args) {
    	ClassPathXmlApplicationContext objContext = new ClassPathXmlApplicationContext("otherObjectsInjection.xml");
    	
    	Employee objEmployee = (Employee)objContext.getBean("bean1");
    	System.out.println("objEmployee :: " + objEmployee);
    	
    	Employee objEmployee1 = (Employee)objContext.getBean("bean2");
    	System.out.println("objEmployee1 :: " + objEmployee1);
    	
    	Employee objEmployee2 = (Employee)objContext.getBean("bean3");
    	System.out.println("objEmployee2 :: " + objEmployee2);
	}

}
