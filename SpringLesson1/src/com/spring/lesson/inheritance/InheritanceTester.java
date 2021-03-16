package com.spring.lesson.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InheritanceTester {
	public static void main(String[] args) {
		ApplicationContext  objContext = new ClassPathXmlApplicationContext("InheritanceExample.xml");
		
		//get parent object
	    Vehicle objVehicle1 = (Vehicle) objContext.getBean("vehicle1");
	    System.out.println("objVehicle1 :: " + objVehicle1);
	    System.out.println("objVehicle1 subclass object :: " + objVehicle1.getObjCar());
	    
	    //get child object
	    Vehicle objVehicle2 = (Vehicle) objContext.getBean("vehicle2");
	    System.out.println("objVehicle2 :: " + objVehicle2);
	    System.out.println("objVehicle2 subclass object :: " + objVehicle2.getObjCar());
	}
}
