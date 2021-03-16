package com.spring.lesson.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCAppTester {

	public static void main(String[] args) {
		ApplicationContext objContext = new ClassPathXmlApplicationContext("jdbcinitial.xml");
		DriverManagerDataSource objDataSource = (DriverManagerDataSource) objContext.getBean("ds");
		System.out.println("objDataSource object :: "  + objDataSource);
//		try {
//			System.out.println("objDataSource connection :: "  + objDataSource.getConnection().toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		JDBCAppPOJO objPojo = (JDBCAppPOJO) objContext.getBean("jdbcpojo1");
		JDBCAppDAO objJdbcDao = (JDBCAppDAO) objContext.getBean("jdbcdao");
//		System.out.println("before insert");
//		objJdbcDao.insert(objPojo);
//		System.out.println("after insert");
		
		JDBCAppPOJO objPojo1 = (JDBCAppPOJO) objContext.getBean("jdbcpojo2");
//		System.out.println("before update");
//		objJdbcDao.update(objPojo1);
//		System.out.println("after update");
		
//		System.out.println("before select");
//		List<JDBCAppPOJO> obj = objJdbcDao.select();
//		System.out.println("after select and size of list :: "+ obj.size());
//		JDBCAppPOJO objJDBCAppPOJO = obj.get(0);
//		System.out.println("objJDBCAppPOJO first name :: " + objJDBCAppPOJO.getFirstName());
//		System.out.println(" ");
		
//		System.out.println("before selectResultSetExtractor");
//		List<JDBCAppPOJO> obj1 = objJdbcDao.selectResultSetExtractor();
//		System.out.println("after selectResultSetExtractor and size of list :: "+ obj1.size());
//		JDBCAppPOJO objJDBCAppPOJO1 = obj.get(0);
//		System.out.println("objJDBCAppPOJO1 first name :: " + objJDBCAppPOJO1.getFirstName());
		
//		System.out.println("before executeQuery for select pointcut testing");
//		List<JDBCAppPOJO> obj = objJdbcDao.executeQuery("Select * from employees where employee_id between ? and ?");
//		System.out.println("after executeQuery for select pointcut testing and size of list :: "+ obj.size());
//		System.out.println(" ");
//		
//		System.out.println("before executeQuery for update/insert pointcut testing");
//		int obj1 = objJdbcDao.executeQuery("update employees set FIRST_NAME=?, LAST_NAME=? where EMPLOYEE_ID=?", objPojo1);
//		System.out.println("after executeQuery for update/insert pointcut testing and statust :: "+ obj1);
		
//		JDBCAppPOJO objPojo5 = (JDBCAppPOJO) objContext.getBean("jdbcpojo5");
//		JDBCAppPOJO objPojo6 = (JDBCAppPOJO) objContext.getBean("jdbcpojo6");
//		JDBCAppPOJO objPojo7 = (JDBCAppPOJO) objContext.getBean("jdbcpojo7");
//		List<JDBCAppPOJO> objJDBCAppPOJO = new ArrayList<JDBCAppPOJO>();
//		objJDBCAppPOJO.add(objPojo5);
//		objJDBCAppPOJO.add(objPojo6);
//		objJDBCAppPOJO.add(objPojo7);
//		System.out.println("before insert batch");
//		int[] status = objJdbcDao.insertBatch(objJDBCAppPOJO);
//		System.out.println("after insert batch status:: "  + status[0] + "," + status[1] + "," + status[2] + ".");
		
		//using daosupport class
//		JDBCAppPOJO objPojo3 = (JDBCAppPOJO) objContext.getBean("jdbcpojo3");
//		JDBCAppDAOSupport objJdbcDao1 = (JDBCAppDAOSupport) objContext.getBean("jdbcdao1");
//		System.out.println("daosupport:: before insert");
//		objJdbcDao1.insert(objPojo3);
//		System.out.println("daosupport:: after insert");
//		
//		JDBCAppPOJO objPojo4 = (JDBCAppPOJO) objContext.getBean("jdbcpojo4");
//		System.out.println("daosupport:: before update");
//		objJdbcDao1.update(objPojo4);
//		System.out.println("daosupport:: after update");
		
//		System.out.println("daosupport:: before select");
//		List<JDBCAppPOJO> obj = objJdbcDao1.select();
//		System.out.println("daosupport:: after select and size of list :: "+ obj.size());
//		JDBCAppPOJO objJDBCAppPOJO = obj.get(0);
//		System.out.println("daosupport:: objJDBCAppPOJO first name :: " + objJDBCAppPOJO.getFirstName());
//		System.out.println(" ");
//		
//		System.out.println("daosupport:: before selectResultSetExtractor");
//		List<JDBCAppPOJO> obj1 = objJdbcDao1.selectResultSetExtractor();
//		System.out.println("daosupport:: after selectResultSetExtractor and size of list :: "+ obj1.size());
//		JDBCAppPOJO objJDBCAppPOJO1 = obj.get(0);
//		System.out.println("daosupport:: objJDBCAppPOJO1 first name :: " + objJDBCAppPOJO1.getFirstName());
		
	}
}
