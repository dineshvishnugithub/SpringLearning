package com.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFilePOJO {
	
	private String name;
	private String fileName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
 	
}
