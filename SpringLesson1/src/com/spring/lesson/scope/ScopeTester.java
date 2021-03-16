package com.spring.lesson.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.lesson.constructor.injection.Person;

public class ScopeTester {
	public static void main(String[] args) {
		ApplicationContext objContext = new ClassPathXmlApplicationContext("scopeTesting.xml");
	
		//using singleton scope
		Person objPerson1 = (Person) objContext.getBean("scope_singleton");
		System.out.println("objPerson1 :: " +objPerson1.hashCode());
		Person objPerson2 = (Person) objContext.getBean("scope_singleton");
		System.out.println("objPerson2 :: " +objPerson2.hashCode());
		
		//using prototype scope
		Person objPerson3 = (Person) objContext.getBean("scope_prototype");
		System.out.println("objPerson3 :: " +objPerson3.hashCode());
		Person objPerson4 = (Person) objContext.getBean("scope_prototype");
		System.out.println("objPerson2 :: " +objPerson4.hashCode());
	}
}
