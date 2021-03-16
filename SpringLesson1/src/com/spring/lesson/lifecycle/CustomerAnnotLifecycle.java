package com.spring.lesson.lifecycle;

public class CustomerAnnotLifecycle {
	
	private String cusAnnotName;
	private int cusAnnotAge;
	
	public CustomerAnnotLifecycle() {
		super();
		System.out.println("CustomerAnnotLifecycle:: inside default constructor");
	}
	
	public CustomerAnnotLifecycle(String cusAnnotName, int cusAnnotAge) {
		super();
		System.out.println("CustomerAnnotLifecycle:: inside parametrized constructor");
		this.cusAnnotName = cusAnnotName;
		this.cusAnnotAge = cusAnnotAge;
	}

	public String getCusAnnotName() {
		return cusAnnotName;
	}

	public void setCusAnnotName(String cusAnnotName) {
		this.cusAnnotName = cusAnnotName;
	}

	public int getCusAnnotAge() {
		return cusAnnotAge;
	}

	public void setCusAnnotAge(int cusAnnotAge) {
		this.cusAnnotAge = cusAnnotAge;
	}
}
