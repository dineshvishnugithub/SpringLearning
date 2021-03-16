package com.spring.lesson.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class JDBCAppDAO extends JDBCAbstractDAO{

	public JDBCAppDAO() {
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

	public void insert(JDBCAppPOJO JDBCAppPOJO) {
		String insertQuery = "Insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) "
				+ "values("+JDBCAppPOJO.getEmployeeId()+",'" + JDBCAppPOJO.getFirstName() + "','" + JDBCAppPOJO.getLastName()+ "','" + JDBCAppPOJO.getEmail() + "','" 
				+ JDBCAppPOJO.getPhoneNumber() + "',to_char(to_date('" + JDBCAppPOJO.getHireDate() + "','yyyy-MM-dd'),'dd/MM/yy'),'" + JDBCAppPOJO.getJobID() + "',"
				+ JDBCAppPOJO.getSalary() + "," + JDBCAppPOJO.getCommissionPct() + "," + JDBCAppPOJO.getManagerId() + ","
				+ JDBCAppPOJO.getDepartmentId() + ")";
		getJdbctemplate().update(insertQuery);
	}
	
	public void update(JDBCAppPOJO JDBCAppPOJO) {
		String updateQuery = "update employees set FIRST_NAME=?, LAST_NAME=? where EMPLOYEE_ID=?";
		getJdbctemplate().update(updateQuery,JDBCAppPOJO.getFirstName(), JDBCAppPOJO.getLastName(), JDBCAppPOJO.getEmployeeId());
	}
	
	public List<JDBCAppPOJO> select() {
		String selectQuery = "Select * from employees where employee_id between ? and ?";
//		Object[] args = new Object[2];
//		args[0] = 100;
//		args[1] = 105;
		return executeQuery(selectQuery);
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
		return (List<JDBCAppPOJO>) getJdbctemplate().query(selectQuery, args, new JDBCResultSetExtractor());
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

	@Override
	public List executeQuery(String selectQuery) {
		Object[] args = new Object[2];
		args[0] = 100;
		args[1] = 105;
		return getJdbctemplate().query(selectQuery, args, new JDBCRowMapper());
	}

	@Override
	public int executeQuery(String updateQuery, JDBCAppPOJO params) {
		return getJdbctemplate().update(updateQuery,params.getFirstName(), params.getLastName(), params.getEmployeeId());
	}
	
	public int[] insertBatch(List<JDBCAppPOJO> objJDBCAppPOJO) {
		 CustomBatchPreparedStatementSetter objBatch = new CustomBatchPreparedStatementSetter();
		 objBatch.setPoJO(objJDBCAppPOJO);
		 
			String insertQuery = "Insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		 return getJdbctemplate().batchUpdate(insertQuery, objBatch);
	}
	
	public class CustomBatchPreparedStatementSetter implements BatchPreparedStatementSetter {
        
		List<JDBCAppPOJO> objJDBCAppPOJO = new ArrayList<JDBCAppPOJO>();
		
		public void setPoJO(List<JDBCAppPOJO> objJDBCAppPOJO) {
			this.objJDBCAppPOJO=objJDBCAppPOJO;
		}
		
		@Override
		public int getBatchSize() {
			// TODO Auto-generated method stub
			return objJDBCAppPOJO.size();
		}

		@Override
		public void setValues(PreparedStatement ps, int rownum) throws SQLException {
			JDBCAppPOJO objJDBCAppPOJOBean = objJDBCAppPOJO.get(rownum);
			ps.setInt(1,objJDBCAppPOJOBean.getEmployeeId());
			ps.setString(2,objJDBCAppPOJOBean.getFirstName());
			ps.setString(3,objJDBCAppPOJOBean.getLastName());
			ps.setString(4,objJDBCAppPOJOBean.getEmail());
			ps.setString(5,objJDBCAppPOJOBean.getPhoneNumber());
			ps.setDate(6,objJDBCAppPOJOBean.getHireDate());
			ps.setString(7,objJDBCAppPOJOBean.getJobID());
			ps.setBigDecimal(8,objJDBCAppPOJOBean.getSalary());
			ps.setBigDecimal(9,objJDBCAppPOJOBean.getCommissionPct());
			ps.setInt(10,objJDBCAppPOJOBean.getManagerId());
			ps.setInt(11,objJDBCAppPOJOBean.getDepartmentId());
		}
		
	}
}
