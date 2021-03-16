package com.spring.lesson.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPAdvisors {

	public AOPAdvisors() {
		// TODO Auto-generated constructor stub
	}
	
	@Before("execution(public void printValues())")
	public void beforeLogging() {
		System.out.println("AOPAdvisors:: beforeLogging: ");
	}
	
	@After("execution(public void printValues())")
	public void afterLogging() {
		System.out.println("AOPAdvisors:: afterLogging: ");
	}
	
	@Before("execution(public * printValue*(int))")
	public void beforeLogging1() {
		System.out.println("AOPAdvisors:: beforeLogging1: ");
	}
	
	@After("execution(public * printValue*(int))")
	public void afterLogging1() {
		System.out.println("AOPAdvisors:: afterLogging1: ");
	}
	
	@Before("execution(* com.spring.lesson.*.CustomerPOJOAOP.printInterfaceArgValues*(int))")
	public void beforeLogging2() {
		System.out.println("AOPAdvisors:: beforeLogging2: ");
	}
	
	@After("execution(* com.spring.lesson.*.CustomerPOJOAOP.printInterfaceArgValues*(int))")
	public void afterLogging2() {
		System.out.println("AOPAdvisors:: afterLogging2: ");
	}
	
//	@Before("execution(public void setValues(..)) and args(String, int))")
	@Before("execution(* com.spring.lesson.aop.EmployeeAOP.setValues(..)) and args(String, int)")
	public void printBeforeEmpValues(JoinPoint jp) {
		System.out.println("AOPAdvisors::  printBeforeEmpValues:: arg1:: " + jp.getArgs()[0] + " arg2:: " + jp.getArgs()[1]);
	}
	
	@After("execution(public void setValues(String, int))")
	public void printAfterEmpValues(JoinPoint jp) {
		System.out.println("AOPAdvisors::  printAfterEmpValues:: arg1:: " + jp.getArgs()[0] + " arg2:: " + jp.getArgs()[1]);
	}
	
	@Around("execution(* com.spring.lesson.aop.EmployeeAOP.setValuesforValidation(..)) and args(String, int)")
	public void printAroundEmpValues(ProceedingJoinPoint pjp) {
		System.out.println("AOPAdvisors::  printAroundEmpValues:: arg1:: " + pjp.getArgs()[0] + " arg2:: " + pjp.getArgs()[1]);
		int allowableEmpId = 1000;
		int inputEmpId=(int) pjp.getArgs()[1];
		Object[] args = pjp.getArgs();
		try {
			if(inputEmpId>allowableEmpId) {
				System.out.println("AOPAdvisors::  printAroundEmpValues:: validation ok to proceed");
				pjp.proceed();
			} else {
				System.out.println("AOPAdvisors::  printAroundEmpValues:: validation not ok to proceed, so defaulting value");
				args[1] = allowableEmpId;
				pjp.proceed(args);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Pointcut("execution(public void setValuesforPointCut(String, int))")
	public void printEmpValuesPointCut() {
		System.out.println("AOPAdvisors:: setValuesforPointCut:: printAfterEmpValuesPointCut::");
	}
	
	@Before("printEmpValuesPointCut()")
	public void printBeforeEmpValuesPointcut(JoinPoint jp) {
		System.out.println("AOPAdvisors::  printBeforeEmpValuesPointcut:: arg1:: " + jp.getArgs()[0] + " arg2:: " + jp.getArgs()[1]);
	}
	
	@After("printEmpValuesPointCut()")
	public void printAfterEmpValuesPointcut(JoinPoint jp) {
		System.out.println("AOPAdvisors::  printAfterEmpValuesPointcut:: arg1:: " + jp.getArgs()[0] + " arg2:: " + jp.getArgs()[1]);
	}
}
