package com.spring.lesson.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.lesson.constructor.injection.Person;

public class AutoWiringTester {
	
	public static void main(String[] args) {
//		ApplicationContext  objContext = new ClassPathXmlApplicationContext("Autowire.xml");
		
//		//byName
//	    Person objPerson = (Person) objContext.getBean("objPerson");
//	    System.out.println("objPerson :: " + objPerson);
//	    System.out.println("objPerson subclass object :: " + objPerson.getObjPersonCharacterisitics());
//	    
//	    //byType
//	    Person objPerson1 = (Person) objContext.getBean("objPerson1");
//	    System.out.println("objPerson1 :: " + objPerson1);
//	    System.out.println("objPerson1 subclass object :: " + objPerson1.getObjPersonCharacterisitics());
//	    
//	    //contructor
//	    Person objPerson2 = (Person) objContext.getBean("objPerson2");
//	    System.out.println("objPerson2 :: " + objPerson2);
//	    System.out.println("objPerson2 subclass object :: " + objPerson2.getObjPersonCharacterisitics());
//	    
//	    //no
//	    Person objPerson3 = (Person) objContext.getBean("objPerson3");
//	    System.out.println("objPerson3 :: " + objPerson3);
//	    System.out.println("objPerson3 subclass object :: " + objPerson3.getObjPersonCharacterisitics());
	    
	    //two constructor with arguments interchanged - byType confusion example
//	    Person objPerson4 = (Person) objContext.getBean("objPerson4");
//	    System.out.println("objPerson4 :: " + objPerson4);
//	    System.out.println("objPerson4 subclass object :: " + objPerson4.getObjPersonCharacterisitics());
		
		ApplicationContext  objContext = new ClassPathXmlApplicationContext("AutowireAnnotation.xml");
	    
	    //autowiring annotation example - to cehck whether object is create or not
//	    Person objPerson5 = (Person) objContext.getBean("objPerson5");
//	    System.out.println("objPerson5 :: " + objPerson5);
//	    System.out.println("objPerson5 subclass object :: " + objPerson5.getObjPersonCharacterisitics());
	    
	    //autowiring annotation example - to cehck whether the name given in @Component is working
//	    Person objPerson6 = (Person) objContext.getBean("objPerson6");
//	    System.out.println("objPerson6 :: " + objPerson6);
//	    System.out.println("objPerson6 subclass object :: " + objPerson6.getObjPersonCharacterisitics());
	    
	    //autowiring annotation example - to cehck whether the name given in @Autowired into PersonCharateristics is working
	    Person objPerson5 = (Person) objContext.getBean("objPerson5");
	    System.out.println("objPerson5 :: " + objPerson5);
	    System.out.println("objPerson5 subclass object :: " + objPerson5.getObjPersonCharacterisitics().getHeight());
	}
}
