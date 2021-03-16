package com.spring.lesson.course1;

public class Employee {
     private int id;
     private String name;
     
     public Employee() {
    	 System.out.println("Inside default consturctor");
     }
      
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("Inside parameterized constructor");
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(String name) {
		this.name = name;
	}
  
	public void displayValues() {
		System.out.println("id:: " + id + " name:: " + name);
	}
}
