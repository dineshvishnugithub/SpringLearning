package com.spring.pojo;

public class EmployeePOJO {

	public EmployeePOJO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String name;
	private int empId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public EmployeePOJO(String name, int empId) {
		super();
		this.name = name;
		this.empId = empId;
	}
}
