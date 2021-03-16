package com.spring.lesson.lifecycle;

public class CustomerLifeCycle extends LifeCycleSuperClass{
	
	@Override
	public String toString() {
		return "CustomerLifeCycle [cusName=" + cusName + ", cusAge=" + cusAge + "]";
	}

	private String cusName;
	private int cusAge;
	
	public CustomerLifeCycle() {
		super();
		System.out.println("CustomerLifeCycle:: inside default constructor");
	}
	
	public CustomerLifeCycle(String cusName, int cusAge) {
		super();
		System.out.println("CustomerLifeCycle:: inside parametrized constructor");
		this.cusName = cusName;
		this.cusAge = cusAge;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getCusAge() {
		return cusAge;
	}

	public void setCusAge(int cusAge) {
		this.cusAge = cusAge;
	}
	
	
}
