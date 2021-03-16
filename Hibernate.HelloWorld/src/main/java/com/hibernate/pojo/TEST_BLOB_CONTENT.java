package com.hibernate.pojo;

import java.sql.Blob;

public class TEST_BLOB_CONTENT implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String FILE_NAME;
	private Blob BLOB_CONTENT;

	public TEST_BLOB_CONTENT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TEST_BLOB_CONTENT(String fILE_NAME, Blob bLOB_CONTENT) {
		super();
		FILE_NAME = fILE_NAME;
		BLOB_CONTENT = bLOB_CONTENT;
	}
	
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	public Blob getBLOB_CONTENT() {
		return BLOB_CONTENT;
	}
	public void setBLOB_CONTENT(Blob bLOB_CONTENT) {
		BLOB_CONTENT = bLOB_CONTENT;
	}
	
	

}
