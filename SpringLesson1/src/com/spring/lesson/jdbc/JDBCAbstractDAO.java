package com.spring.lesson.jdbc;

import java.util.List;

public abstract class JDBCAbstractDAO {
	
	public List executeQuery(String query) {
		return null;
	}
	
	public int executeQuery(String query, JDBCAppPOJO objPojo) {
		return 0;
	}

}
