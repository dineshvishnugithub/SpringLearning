package com.spring.lesson.jdbc;

import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class JDBCAspect {
	
    boolean append = true;
    Logger logger;
    
    public void logging() throws Exception{
    	FileHandler handler = new FileHandler("D://mySpring/SampleSpringApplication/SpringLesson1/src/com/spring/lesson/jdbc/jdbcLogs.log", append);
    	logger = Logger.getLogger("com.spring.lesson.jdbc");
    	logger.addHandler(handler);
    }
	
	public JDBCAspect() {
	}
   
	@Pointcut("execution(* com.spring.lesson.jdbc.JDBCAbstractDAO.executeQuery(String))")
//	@Pointcut("execution(* com.spring.lesson.jdbc.JDBCAppDAO.select(..))")
//	@Pointcut("execution(public List* select())")
	public void addPointcut_Select() {
//		System.out.println("Advice1: Inside addPointcut:: calling executeQuery() method");
	}
	
//	@Before("execution(* com.spring.lesson.jdbc.JDBCAppDAO.executeQuery(..))")
//	@Before("execution(public List* select())")
//	@Before("execution(* com.spring.lesson.jdbc.JDBCAppDAO.select(..))")
	@Before("addPointcut_Select()")
	public void logBeforeQuery(JoinPoint jp) {
		System.out.println("Advice1: Inside before: logQuery:: " + jp.getArgs()[0]);
		logger.info("Advice1: Inside before: logQuery:: " + jp.getArgs()[0]);
	}
	
	@After("addPointcut_Select()")
	public void logAfterQuery() {
//		System.out.println("Inside after: logQuery:: ");
	}
	
	@Around("addPointcut_Select()")
	public List<JDBCAppPOJO> logAroundResults(ProceedingJoinPoint pjp) throws Exception {
		logging();
		System.out.println("Advice1: Inside around(before): logAroundResults:: " + pjp.getArgs()[0]);
		try {
			List<JDBCAppPOJO> obj = (List<JDBCAppPOJO>) pjp.proceed();
			System.out.println("Advice2: Inside around(after): logAroundResults:: " + obj.size());
			logger.info("Advice2: Inside around(after): logAroundResults:: " + obj.size());
			return obj;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Pointcut("execution(* com.spring.lesson.jdbc.JDBCAbstractDAO.executeQuery(String, JDBCAppPOJO))")
	public void addPointcut_Update() {
	}
	
	@Before("addPointcut_Update()")
	public void addPointcut_Update(JoinPoint jp) {
		System.out.println("Advice3: Inside before: logQuery:: " + jp.getArgs()[0]);
		logger.info("Advice3: Inside before: logQuery:: " + jp.getArgs()[0]);
	}
	
	@Around("addPointcut_Update()")
	public int logAroundResultsUpdate(ProceedingJoinPoint pjp) throws Exception {
		logging();
		System.out.println("Advice3: Inside around(before): logAroundResultsUpdate:: " + pjp.getArgs()[0]);
		try {
			int status = (int) pjp.proceed();
			System.out.println("Advice4: Inside around(after): logAroundResultsUpdate:: " + status);
			logger.info("Advice4: Inside around(after): logAroundResultsUpdate:: " + status);
			return status;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
