package com.spring.lesson.course1;

import java.util.Iterator;
import java.util.List;

public class Employee1 {
    private int id;
    private String name;
    private List<String> objList;
    
	public int getId() {
		return id;
	}
	public Employee1() {
		
	}
	public Employee1(int id, String name, List<String> objList) {
		super();
		this.id = id;
		this.name = name;
		this.objList = objList;
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
	public List<String> getObjList() {
		return objList;
	}
	public void setObjList(List<String> objList) {
		this.objList = objList;
	}
	
	public void display() {
		System.out.println("id:: "+id + "name:: " + name + "list:: " + objList.size());
		Iterator<String> objIter = objList.iterator();
		while(objIter.hasNext()) {
			System.out.println("List object " + objIter.next());
		}
	}
}
