package com.spring.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringCustomDao {
	
	public SpringCustomDao() {
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
	
	public void insert(String file_name, InputStream objBlob) throws SQLException {
		String insertQuery = "Insert into TEST_BLOB_CONTENT(FILE_NAME,BLOB_CONTENT) "
				+ "values('"+file_name+"'," + objBlob + ")";
		System.out.println("query::-->" + insertQuery);
		String insertQuery1 = "Insert into TEST_BLOB_CONTENT(FILE_NAME,BLOB_CONTENT) "
				+ "values(?,?)";
		System.out.println("query1::-->" + insertQuery1);
		Connection conn = getObjJdbcTemplate().getDataSource().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(insertQuery1);
		pstmt.setString(1, file_name);
		pstmt.setBlob(2, objBlob);
		int i = pstmt.executeUpdate();
		System.out.println("results is :: " + i);
//		getObjJdbcTemplate().update(insertQuery);
	}
}
