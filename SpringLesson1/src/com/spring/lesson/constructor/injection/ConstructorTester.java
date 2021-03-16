package com.spring.lesson.constructor.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ConstructorTester {
    
	public static void main(String[] args) {
		ApplicationContext objContext = new ClassPathXmlApplicationContext("constructorInjection.xml");
	
//		Person objPerson = (Person) objContext.getBean("constructoreg1");
//		System.out.println("objPerson :: " +objPerson);
		
//		Person objPerson1 = (Person) objContext.getBean("constructoreg2");
//		System.out.println("objPerson1 :: " +objPerson1);
		
//		Person objPerson2 = (Person) objContext.getBean("constructoreg3");
//		System.out.println("objPerson2 :: " +objPerson2);
		
//		Person objPerson3 = (Person) objContext.getBean("constructoreg4");
//		System.out.println("objPerson3 :: " +objPerson3);
		
//		Person objPerson4 = (Person) objContext.getBean("constructoreg5");
//		System.out.println("objPerson4 :: " +objPerson4);
		
//		Person objPerson5 = (Person) objContext.getBean("constructoreg6");
//		System.out.println("objPerson5 :: " +objPerson5);
		
//		Person objPerson6 = (Person) objContext.getBean("constructoreg7");
//		System.out.println("objPerson6 :: " +objPerson6);
		
		//using bean factory
//		BeanFactory objBeanFact = new XmlBeanFactory(new ClassPathResource("constructorInjection.xml"));
		
		//using application context from class path
//		FileSystemXmlApplicationContext objFileContext = new FileSystemXmlApplicationContext("classpath:constructorInjection.xml");
//		Person objPerson6 = (Person) objFileContext.getBean("constructoreg7");
//		System.out.println("objPerson6 :: " +objPerson6);
	}
}
