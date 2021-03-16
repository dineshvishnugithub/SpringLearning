package com.spring.lesson.constructor.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="objPerson6")
public class Person {
	
	private String name;
	private int age;
	
	@Autowired
	@Qualifier(value="objPersonCharac_byTypeConfusion1")
	private PersonCharacterisitics objPersonCharacterisitics;
	
	public Person() {
		
	}
	
	public Person(PersonCharacterisitics objPersonCharacterisitics) {
		super();
		this.objPersonCharacterisitics = objPersonCharacterisitics;
		System.out.println("Inside constructor containing subclass object");
	}

	public Person(String name) {
		super();
		this.name = name;
		System.out.println("Inside constructor containing name object");
	}

	public Person(int age) {
		super();
		this.age = age;
		System.out.println("Inside constructor containing age object");
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("Inside constructor containing name and age object");
	}
	
	public Person(String name, int age, PersonCharacterisitics objPersonCharacterisitics) {
		super();
		this.name = name;
		this.age = age;
		this.objPersonCharacterisitics = objPersonCharacterisitics;
		System.out.println("Inside constructor containing all 3 object");
	}

//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + ", objPersonCharacterisitics=" + objPersonCharacterisitics
//				+ "]";
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Inside name setter");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("Inside age setter");
	}

	public PersonCharacterisitics getObjPersonCharacterisitics() {
		return objPersonCharacterisitics;
	}

	public void setObjPersonCharacterisitics(PersonCharacterisitics objPersonCharacterisitics) {
		this.objPersonCharacterisitics = objPersonCharacterisitics;
		System.out.println("Inside objPersonCharacterisitics setter");
	}
	
	

}
