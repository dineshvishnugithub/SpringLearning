package com.spring.lesson.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTester {

	public static void main(String[] args) {
		ApplicationContext objContext = new ClassPathXmlApplicationContext("aopinitial.xml");
		
		EmployeeAOP objEmpAop = (EmployeeAOP) objContext.getBean("empName");
		//this object uses CGLib to create object
		System.out.println("class using cg lib ::: " + objEmpAop.getClass().getName());
		
		System.out.println("Using annotation");
		System.out.println("1.1 Using annotation before printValues()");
		//before through xml is called first, and then before thro annotation is called
		objEmpAop.printValues();
		//after thorugh annotation is called first, and then after thro XML is called
		System.out.println("1.1 Using annotation after printValues()");
		
		System.out.println("1.2 Using annotation before printValuesArgs()");
		//this aspect is only thro annotation and not through XML as it is not defined
		objEmpAop.printValuesArgs(2);
		System.out.println("1.2 Using annotation before printValuesArgs()");
		
		System.out.println("Using xml");
		System.out.println("2.1 Using XML before printValues()");
		objEmpAop.printValues();
		System.out.println("2.1 Using XML before printValues()");
		System.out.println("2.2 Using XML before printValuesArgs()");
		objEmpAop.printValuesArgs(2);
		System.out.println("2.2 Using XML before printValuesArgs()");
		System.out.println(" ");
		
		CustomerAOPInterface objCustAop =  (CustomerAOPInterface) objContext.getBean("custName");
		//this object uses reflect.Proxy to create object
		System.out.println("Using xml and Interface, printing object objCustAop:: " + objCustAop.getClass().getName());
		System.out.println("3.1 Using XML before printValues()");
		objCustAop.printInterfaceValues();
		System.out.println("3.1 Using XML after printValues()");
		System.out.println("3.2 Using XML before printValuesArgs()");
		objCustAop.printInterfaceArgValues(4);
		System.out.println("3.2 Using XML after printValuesArgs()");
		System.out.println(" ");
		
		
		CustomerAOPInterface objCustFinalAop =  (CustomerAOPInterface) objContext.getBean("custFinalName");
		//this object uses reflect.Proxy to create object
		//if proxy-target object is true enabled in xml, then proxy object using CGlib is not possible for fianl class as it cant create subclass
		System.out.println("Using xml and Interface, printing object objCustFinalAop:: " + objCustFinalAop.getClass().getName());
		System.out.println("4.1 Using XML before printValues()");
		objCustFinalAop.printInterfaceValues();
		System.out.println("4.1 Using XML after printValues()");
		System.out.println("4.2 Using XML before printValuesArgs()");
		objCustFinalAop.printInterfaceArgValues(6);
		System.out.println("4.2 Using XML after printValuesArgs()");
		System.out.println(" ");
		
		System.out.println("1.3 Using annotation before setValues() - JoinPoint usage");
		objEmpAop.setValues("Joint point String", 1);
		System.out.println("1.3 Using annotation after setValues() - JoinPoint usage");
		System.out.println(" ");
		
		System.out.println("1.4 Using annotation before setValuesforValidation() - ProceedingJoinPoint usage");
		objEmpAop.setValuesforValidation("Proceeding Joint point String", 1);
		System.out.println(" ");
		objEmpAop.setValuesforValidation("Proceeding Joint point String", 1004);
		System.out.println("1.4 Using annotation after setValuesforValidation() - ProceedingJoinPoint usage");
		System.out.println(" ");
		
		
		System.out.println("1.5 Using annotation before setValuesforPointCut() - Pointcut usage");
		objEmpAop.setValuesforPointCut("Pointcut String", 1);
		System.out.println("1.5 Using annotation after setValuesforPointCut() - Pointcut usage");
		System.out.println(" ");
		
	}
}
