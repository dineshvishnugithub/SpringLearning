package com.spring.lesson.inheritance;

public class TataCar extends Car{
	
	private String make;
	private String model;
	private int yrOfMfg;
	
	public TataCar(String make, String model, int yrOfMfg) {
		super(make, model, yrOfMfg);
		System.out.println("Inside TataCar constructor - start");
		this.make = make;
		this.model = model;
		this.yrOfMfg = yrOfMfg;
		System.out.println("Inside TataCar constructor - start");
	}
}
