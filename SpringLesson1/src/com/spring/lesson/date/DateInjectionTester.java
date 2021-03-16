package com.spring.lesson.date;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DateInjectionTester {
	
	public static void main(String[] args) {
		ApplicationContext objContext = new ClassPathXmlApplicationContext("dateinjection.xml");
		
		//date parser1
		CustomerDate objDateParserFactoryMthd = (CustomerDate) objContext.getBean("bean1");
		System.out.println("objDateParserFactoryMthd :: " +objDateParserFactoryMthd.getObjDate());
		
		//date parser2
		CustomerDate objDateParserFactoryMthd1 = (CustomerDate) objContext.getBean("bean2");
		System.out.println("objDateParserFactoryMthd1 :: " +objDateParserFactoryMthd1.getObjDate());
		
		//date parser3
		CustomerDate objDateParserFactoryMthd2 = (CustomerDate) objContext.getBean("bean4");
		System.out.println("objDateParserFactoryMthd2 :: " +objDateParserFactoryMthd2.getObjStringDate());
		
		//decimal parser3
		CustomerDate objDecimalParserFactoryMthd = (CustomerDate) objContext.getBean("bean3");
		System.out.println("objDecimalParserFactoryMthd :: " +objDecimalParserFactoryMthd.getObjSalary());
		
		//date parser4
		CustomerDate objDateParserFactoryMthd3 = (CustomerDate) objContext.getBean("bean5");
		System.out.println("objDateParserFactoryMthd3 :: " +objDateParserFactoryMthd3.getObjSqlDate());
		
		//date parser5
//		CustomerDate objDateParserFactoryMthd4 = (CustomerDate) objContext.getBean("bean6");
//		System.out.println("objDateParserFactoryMthd4 :: " +objDateParserFactoryMthd4.getObjSqlDate());
		
	}

}
