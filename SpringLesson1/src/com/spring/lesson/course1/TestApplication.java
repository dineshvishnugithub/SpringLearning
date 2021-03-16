package com.spring.lesson.course1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplication {

	 public static void main(String[] args) {
//		Resource objResource = new ClassPathResource("springConfigurator.xml");
		 
		System.out.println("Entering main method");
		ClassPathXmlApplicationContext objContext = new ClassPathXmlApplicationContext("springConfigurator.xml");
//		BeanFactory objBeanFactory = new XmlBeanFactory(objResource);
		System.out.println("objContext:: " + objContext);
		
		Student objStudent = (Student) objContext.getBean("bean1");
		objStudent.displayName();
		objContext.close();
		
//		System.out.println("objBeanFactory:: " + objBeanFactory);
//		Employee objStudent = (Employee) objBeanFactory.getBean("bean2");
//		objStudent.displayValues();
		
//		System.out.println("objBeanFactory:: " + objBeanFactory);
//		Employee objStudent = (Employee) objBeanFactory.getBean("bean3");
//		objStudent.displayValues();
	    
//		System.out.println("objBeanFactory:: " + objBeanFactory);
//		Employee1 objStudent = (Employee1) objBeanFactory.getBean("bean4");
//		objStudent.display();
	}
}
