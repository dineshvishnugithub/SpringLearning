package com.spring.lesson.lifecycle;

public class EmployeeAnnotLifecycle {

	private String empAnnotName;
	private int empAnnotAge;
	
	public EmployeeAnnotLifecycle() {
		super();
		System.out.println("EmployeeAnnotLifecycle:: inside default constructor");
	}
	
	public EmployeeAnnotLifecycle(String empAnnotName, int empAnnotAge) {
		super();
		System.out.println("EmployeeAnnotLifecycle:: inside parametrized constructor");
		this.empAnnotName = empAnnotName;
		this.empAnnotAge = empAnnotAge;
	}

	public String getEmpAnnotName() {
		return empAnnotName;
	}

	public void setEmpAnnotName(String empAnnotName) {
		this.empAnnotName = empAnnotName;
	}

	public int getEmpAnnotAge() {
		return empAnnotAge;
	}

	public void setEmpAnnotAge(int empAnnotAge) {
		this.empAnnotAge = empAnnotAge;
	}

}
