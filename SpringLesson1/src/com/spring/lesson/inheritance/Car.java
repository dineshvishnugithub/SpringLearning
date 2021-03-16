package com.spring.lesson.inheritance;

public class Car {
	
	private String make;
	private String model;
	private int yrOfMfg;
	
	public Car(String make, String model, int yrOfMfg) {
		super();
		System.out.println("Inside car constructor - start");
		this.make = make;
		this.model = model;
		this.yrOfMfg = yrOfMfg;
		System.out.println("Inside car constructor - end");
	}
	
}
