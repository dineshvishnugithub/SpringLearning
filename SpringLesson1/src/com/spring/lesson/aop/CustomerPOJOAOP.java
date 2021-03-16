package com.spring.lesson.aop;

public class CustomerPOJOAOP implements CustomerAOPInterface{
	
	private String custName;
	private int custId;

	public CustomerPOJOAOP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public CustomerPOJOAOP(String custName, int custId) {
		super();
		this.custName = custName;
		this.custId = custId;
	}

	@Override
	public void printInterfaceValues() {
		System.out.println("Inside CustomerPOJOAOP printInterfaceValues:: custName:: " + custName + " custId:: " + custId);		
	}
	
	@Override
	public void printInterfaceArgValues(int arg1) {
		System.out.println("Inside CustomerPOJOAOP printInterfaceArgValues:: custName:: " + custName + " custId:: " + custId + " arg1:: " + arg1);		
	}
}
