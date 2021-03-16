package com.spring.lesson.aop;

public final class CustomerFinalPOJOAOP implements CustomerAOPInterface{
	
	private String custFinalName;
	private int custFinalId;

	public String getCustFinalName() {
		return custFinalName;
	}

	public void setCustFinalName(String custFinalName) {
		this.custFinalName = custFinalName;
	}

	public int getCustFinalId() {
		return custFinalId;
	}

	public CustomerFinalPOJOAOP(String custFinalName, int custFinalId) {
		super();
		this.custFinalName = custFinalName;
		this.custFinalId = custFinalId;
	}

	public void setCustFinalId(int custFinalId) {
		this.custFinalId = custFinalId;
	}

	public CustomerFinalPOJOAOP() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printInterfaceValues() {
		System.out.println("Inside CustomerFinalPOJOAOP printInterfaceValues() :: custFinalName:: " + custFinalName + " custFinalId:: " + custFinalId);
	}

	@Override
	public void printInterfaceArgValues(int obj) {
		System.out.println("Inside CustomerFinalPOJOAOP printInterfaceArgValues() :: custFinalName:: " + custFinalName + " custFinalId:: " + custFinalId + " obj:: "+ obj);
	}
	
}
