package com.spring.lesson.configuration;

public class Address {
    private String streetName;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Address() {
		super();
		System.out.println("Inside address default constructor");
		// TODO Auto-generated constructor stub
	}

	public Address(String streetName) {
		super();
		this.streetName = streetName;
	}
    
	
}
