package com.spring.lesson.constructor.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PersonCharacterisitics {
	
	private String color;
	private String race;
	private int height;
	private double weight;
	
	public PersonCharacterisitics() {
		System.out.println("Inside PersonCharacterisitics default constructor");
	}
	
//	public PersonCharacterisitics(String color, String race, int height, double weight) {
//		super();
//		this.color = color;
//		this.race = race;
//		this.height = height;
//		this.weight = weight;
//		System.out.println("Inside PersonCharacterisitics 4 arg constructor");
//	}
	
//	@Autowired
//	@Qualifier("objPersonCharac_byTypeConfusion1")
	public PersonCharacterisitics(int height, String color, String race) {
		System.out.println("Inside PersonCharacterisitics 3 arg constructor - int first - start");
		this.color = color;
		this.race = race;
		this.height = height;
		System.out.println("Inside PersonCharacterisitics 3 arg constructor - int first - end");
	}
	
//	@Autowired
//	@Qualifier("objPersonCharac_byTypeConfusion2") 
	public PersonCharacterisitics(String color, int height, String race) {
		super();
		System.out.println("Inside PersonCharacterisitics 3 arg constructor - string first");
		this.color = color;
		this.race = race;
		this.height = height;
		System.out.println("Inside PersonCharacterisitics 3 arg constructor - string end");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
		System.out.println("Inside set color");
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
		System.out.println("Inside set race");
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		System.out.println("Inside set height");
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		System.out.println("Inside set weight");
	}

//	@Override
//	public String toString() {
//		return "PersonCharacterisitics [color=" + color + ", race=" + race + ", height=" + height + ", weight=" + weight
//				+ "]";
//	}
	
}
