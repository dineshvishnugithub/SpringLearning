package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.pojo.EmployeePOJO;

@Repository
public class CustomDao {

	public CustomDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	JdbcTemplate objJdbcTemplate;

	public JdbcTemplate getObjJdbcTemplate() {
		return objJdbcTemplate;
	}

	public void setObjJdbcTemplate(JdbcTemplate objJdbcTemplate) {
		this.objJdbcTemplate = objJdbcTemplate;
	}
	
	public void insert(EmployeePOJO objEmployeePOJO) {
		String insertQuery = "Insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) "
				+ "values("+objEmployeePOJO.getEmployeeId()+",'" + objEmployeePOJO.getFirstName() + "','" + objEmployeePOJO.getLastName()+ "','" + objEmployeePOJO.getEmail() + "','" 
				+ objEmployeePOJO.getPhoneNumber() + "',to_char(to_date('" + objEmployeePOJO.getHireDate() + "','yyyy-MM-dd'),'dd/MM/yy'),'" + objEmployeePOJO.getJobID() + "',"
				+ objEmployeePOJO.getSalary() + "," + objEmployeePOJO.getCommissionPct() + "," + objEmployeePOJO.getManagerId() + ","
				+ objEmployeePOJO.getDepartmentId() + ")";
		getObjJdbcTemplate().update(insertQuery);
	}

	public List<EmployeePOJO> selectAllEmployees() {
		String query = "select * from employees where employee_id > 500";
		return getObjJdbcTemplate().query(query, new CustomRowMapper());
	}
	
	class CustomRowMapper implements RowMapper<EmployeePOJO> {

		public EmployeePOJO mapRow(ResultSet rs, int rownum) throws SQLException {
			EmployeePOJO objEmployeePOJO = new EmployeePOJO();
			objEmployeePOJO.setEmployeeId(rs.getInt(1));
			objEmployeePOJO.setFirstName(rs.getString(2));
			objEmployeePOJO.setLastName(rs.getString(3));
			objEmployeePOJO.setEmail(rs.getString(4));
			objEmployeePOJO.setPhoneNumber(rs.getString(5));
			objEmployeePOJO.setHireDate(rs.getDate(6));
			objEmployeePOJO.setJobID(rs.getString(7));
			objEmployeePOJO.setSalary(rs.getBigDecimal(8));
			objEmployeePOJO.setCommissionPct(rs.getBigDecimal(9));
			objEmployeePOJO.setManagerId(rs.getInt(10));
			objEmployeePOJO.setDepartmentId(rs.getInt(11));
			return objEmployeePOJO;
		}
		
	}

	public List<EmployeePOJO> selectAllEmployeesBeanPropertyMapper() {
		String query = "select * from employees where employee_id > 500";
		return getObjJdbcTemplate().query(query,new BeanPropertyRowMapper(EmployeePOJO.class));
	}

}
