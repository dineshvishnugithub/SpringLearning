package com.spring.lesson.jdbc;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.spring.lesson.jdbc.JDBCAppDAO.JDBCResultSetExtractor;
import com.spring.lesson.jdbc.JDBCAppDAO.JDBCRowMapper;

import oracle.sql.BLOB;

public class JDBCAppDAOSupport extends JdbcDaoSupport {

	public JDBCAppDAOSupport() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(JDBCAppPOJO JDBCAppPOJO) {
		String insertQuery = "Insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) "
				+ "values("+JDBCAppPOJO.getEmployeeId()+",'" + JDBCAppPOJO.getFirstName() + "','" + JDBCAppPOJO.getLastName()+ "','" + JDBCAppPOJO.getEmail() + "','" 
				+ JDBCAppPOJO.getPhoneNumber() + "',to_char(to_date('" + JDBCAppPOJO.getHireDate() + "','yyyy-MM-dd'),'dd/MM/yy'),'" + JDBCAppPOJO.getJobID() + "',"
				+ JDBCAppPOJO.getSalary() + "," + JDBCAppPOJO.getCommissionPct() + "," + JDBCAppPOJO.getManagerId() + ","
				+ JDBCAppPOJO.getDepartmentId() + ")";
		getJdbcTemplate().update(insertQuery);
	}
	
	public void update(JDBCAppPOJO JDBCAppPOJO) {
		String updateQuery = "update employees set FIRST_NAME=?, LAST_NAME=? where EMPLOYEE_ID=?";
		getJdbcTemplate().update(updateQuery,JDBCAppPOJO.getFirstName(), JDBCAppPOJO.getLastName(), JDBCAppPOJO.getEmployeeId());
	}
	
	public List<JDBCAppPOJO> select() {
		String selectQuery = "Select * from employees where employee_id between ? and ?";
		Object[] args = new Object[2];
		args[0] = 100;
		args[1] = 105;
		return getJdbcTemplate().query(selectQuery, args, new JDBCRowMapper());
	}
	
	class JDBCRowMapper implements RowMapper<JDBCAppPOJO> {
		
		@Override
		public JDBCAppPOJO mapRow(ResultSet rs, int arg1) throws SQLException {
//			System.out.println("current row cursor row no:: " + arg1);
			JDBCAppPOJO objJDBCAppPOJO = new JDBCAppPOJO();
				objJDBCAppPOJO.setEmployeeId(rs.getInt(1));
				objJDBCAppPOJO.setFirstName(rs.getString(2));
				objJDBCAppPOJO.setLastName(rs.getString(3));
				objJDBCAppPOJO.setEmail(rs.getString(4));
				objJDBCAppPOJO.setPhoneNumber(rs.getString(5));
				objJDBCAppPOJO.setHireDate(rs.getDate(6));
				objJDBCAppPOJO.setJobID(rs.getString(7));
				objJDBCAppPOJO.setSalary(rs.getBigDecimal(8));
				objJDBCAppPOJO.setCommissionPct(rs.getBigDecimal(9));
				objJDBCAppPOJO.setManagerId(rs.getInt(10));
				objJDBCAppPOJO.setDepartmentId(rs.getInt(11));
			return objJDBCAppPOJO;
		}
	
	}
	
	public List<JDBCAppPOJO> selectResultSetExtractor() {
		String selectQuery = "Select * from employees where employee_id between ? and ?";
		Object[] args = new Object[2];
		args[0] = 100;
		args[1] = 105;
		return (List<JDBCAppPOJO>) getJdbcTemplate().query(selectQuery, args, new JDBCResultSetExtractor());
	}
	
	class JDBCResultSetExtractor implements ResultSetExtractor{

		@Override
		public List<JDBCAppPOJO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<JDBCAppPOJO> objList = new ArrayList<JDBCAppPOJO>();
			System.out.println("Inside extractData");
			while(rs.next()) {
				JDBCAppPOJO objJDBCAppPOJO = new JDBCAppPOJO();
				objJDBCAppPOJO.setEmployeeId(rs.getInt(1));
				objJDBCAppPOJO.setFirstName(rs.getString(2));
				objJDBCAppPOJO.setLastName(rs.getString(3));
				objJDBCAppPOJO.setEmail(rs.getString(4));
				objJDBCAppPOJO.setPhoneNumber(rs.getString(5));
				objJDBCAppPOJO.setHireDate(rs.getDate(6));
				objJDBCAppPOJO.setJobID(rs.getString(7));
				objJDBCAppPOJO.setSalary(rs.getBigDecimal(8));
				objJDBCAppPOJO.setCommissionPct(rs.getBigDecimal(9));
				objJDBCAppPOJO.setManagerId(rs.getInt(10));
				objJDBCAppPOJO.setDepartmentId(rs.getInt(11));
				objList.add(objJDBCAppPOJO);
			}
			return objList;
		}
		
	}
	
	public void insertBlob(String filename, FileInputStream fin) {
		String insertQuery = "Insert into test_blob_content(file_name,blob_content) values(?,?)";
		getJdbcTemplate().update(insertQuery, new Object[] {filename, fin});
	}

}
