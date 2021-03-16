package com.spring.lesson.configuration;

public class Education {
	
	private String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Education() {
		super();
		System.out.println("Inside education default constructor");
		// TODO Auto-generated constructor stub
	}

	public Education(String courseName) {
		super();
		this.courseName = courseName;
	}

}
