package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.pojo.EmployeePOJO;

public class JDBCPersistDAO {

	public JDBCPersistDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	public void insert(EmployeePOJO empPOJO) {
		String insertQuery = "Insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) "
				+ "values("+empPOJO.getEmployeeId()+",'" + empPOJO.getFirstName() + "','" + empPOJO.getLastName()+ "','" + empPOJO.getEmail() + "','" 
				+ empPOJO.getPhoneNumber() +
				"',to_char(to_date('2020-01-12','yyyy-MM-dd'),'dd/MM/yy'),'" + 
				empPOJO.getJobID() + "',"
				+ empPOJO.getSalary() + "," + empPOJO.getCommissionPct() + "," + empPOJO.getManagerId() + ","
				+ empPOJO.getDepartmentId() + ")";
		getJdbctemplate().update(insertQuery);
	}

}
