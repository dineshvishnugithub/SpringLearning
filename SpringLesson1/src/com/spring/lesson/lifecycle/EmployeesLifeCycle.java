package com.spring.lesson.lifecycle;

public class EmployeesLifeCycle {

	private String empName;
	private int empAge;
	
	public EmployeesLifeCycle() {
		super();
		System.out.println("EmployeesLifeCycle:: inside default constructor");
	}
	
	public EmployeesLifeCycle(String empName, int empAge) {
		super();
		System.out.println("EmployeesLifeCycle:: inside parametrized constructor");
		this.empName = empName;
		this.empAge = empAge;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "EmployeesLifeCycle [empName=" + empName + ", empAge=" + empAge + "]";
	}
	
}
