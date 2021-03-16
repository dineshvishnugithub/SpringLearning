package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpringCustomAspect {

	 @Before("execution(* com.spring.service.SpringCustomService.*(..)) and args(name,empId)")
	 public void beforeAdvice(JoinPoint jp, String name, String empId) {
		 System.out.println("SpringCustomAspect:: Inside beforeAdvice jp:: " + jp.getSignature());
		 System.out.println("Parameters in are : name:: " + name + " empId:: " + empId);
	 }
	 
//	 @Before("execution(* com.spring.service.SpringCustomService.*(..)) and args(empId)")
//	 public void beforeAdvice1(JoinPoint jp, String empId) {
//		 System.out.println("SpringCustomAspect:: Inside beforeAdvice1 jp:: " + jp.getSignature());
//		 System.out.println("Parameters in are : empId:: " + empId);
//	 }
	 
	 @After("execution(* com.spring.service.SpringCustomService.*(..)) and args(name,empId)")
	 public void afterAdvice(JoinPoint jp, String name, String empId) {
		 System.out.println("SpringCustomAspect:: Inside afterAdvice jp:: " + jp.getSignature());
		 System.out.println("Parameters in are : name:: " + name + " empId:: " + empId);
	 }
	 
	 @AfterThrowing(pointcut="execution(* com.spring.service.SpringCustomService.*(..)) and args(name,empId)", throwing="exp")
	 public void afterThrowingAdvice(JoinPoint jp, String name, String empId, Exception exp) {
		 System.out.println("SpringCustomAspect:: Inside afterThrowingAdvice jp:: " + jp.getSignature());
		 System.out.println("Parameters in are : name:: " + name + " empId:: " + empId);
		 System.out.println("SpringCustomAspect:: Inside afterThrowingAdvice exp:: "+ exp.getMessage());
	 }
	 
	 @Around("execution(* com.spring.service.SpringCustomService.update*(..)) and args(name)")
	 public String aroundAdvice(ProceedingJoinPoint pjp, String name) throws Throwable {
		 System.out.println("SpringCustomAspect:: Inside aroundAdvice pjp:: " + pjp.getSignature());
		 System.out.println("Parameters in are : name:: " + name );
		 
		 Object[] args = pjp.getArgs();
		 System.out.println("Parameters in pjp are : name:: " + args[0]);
		 args[0] = "Dinesh1";
		 String returnOutput = (String) pjp.proceed(args);
		 System.out.println("returnOutput:: "+ returnOutput);
		 System.out.println("Input parameter name:: " + name + "is updated with values as " + args[0]);
		 
		 return returnOutput;
		 
	 }
}
