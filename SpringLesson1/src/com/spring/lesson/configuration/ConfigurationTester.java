package com.spring.lesson.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.lesson.constructor.injection.Person;

public class ConfigurationTester {
	
	public static void main(String[] args) {
		ApplicationContext objContext = new AnnotationConfigApplicationContext(ConfigurationMain.class);
		
		//address is singleton object - test two objects
		Address objAddress = (Address) objContext.getBean("addressInfo");
		System.out.println("objAddress :: " + objAddress);
		
		Address objAddress1 = (Address) objContext.getBean("addressInfo");
		System.out.println("objAddress1 :: " + objAddress1);
		
		//education is prototype object - test two objects
		Education objEducation = (Education) objContext.getBean("educationInfo");
		System.out.println("objEducation :: " + objEducation);
		
		Education objEducation1 = (Education) objContext.getBean("educationInfo");
		System.out.println("objEducation1 :: " + objEducation1);
		
		//accessing person object from xml
		Person objPerson1 = (Person) objContext.getBean("objPerson1");
		System.out.println("objPerson1 :: " + objPerson1);
		
		//accessing person object from @ComponentScan declared in Person class with object as person6
		Person objPerson2 = (Person) objContext.getBean("objPerson6");
		System.out.println("objPerson2 :: " + objPerson2);
	}

}
