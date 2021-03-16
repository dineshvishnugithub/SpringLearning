package com.spring.lesson.aop;

public class EmployeeAOP {

	public EmployeeAOP() {
		// TODO Auto-generated constructor stub
	}
    
	private String empName;
	private int empId;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public EmployeeAOP(String empName, int empId) {
		super();
		this.empName = empName;
		this.empId = empId;
	}
	
	public void printValues() {
		System.out.println("empName :: " + empName + " empId :: " + empId);
	}
	
	public void printValuesArgs(int objVal) {
		System.out.println("empName :: " + empName + " empId :: " + empId + " objVal:: " + objVal);
	}
	
	public void setValues(String empName, int empId) {
		this.empName=empName;
		this.empId=empId;
		System.out.println("setValues:: values set are:: empName :: " + empName + " empId :: " + empId);
	}
	
	public void setValuesforValidation(String empName, int empId) {
		this.empName=empName;
		this.empId=empId;
		System.out.println("setValuesforValidation:: values set are:: empName :: " + empName + " empId :: " + empId);
	}
	
	public void setValuesforPointCut(String empName, int empId) {
		this.empName=empName;
		this.empId=empId;
		System.out.println("setValuesforPointCut:: values set are:: empName :: " + empName + " empId :: " + empId);
	}
}
