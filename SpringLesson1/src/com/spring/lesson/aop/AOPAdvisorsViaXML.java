package com.spring.lesson.aop;

public class AOPAdvisorsViaXML {

	public AOPAdvisorsViaXML() {
		// TODO Auto-generated constructor stub
	}
	
	public void beforePrintLogViaXML() {
		System.out.println("AOPAdvisorsViaXML: inside beforePrintLogViaXML");
	}

	public void afterPrintLogViaXML() {
		System.out.println("AOPAdvisorsViaXML: inside afterPrintLogViaXML");
	}
	
	public void beforePrintArgsLogViaXML() {
		System.out.println("AOPAdvisorsViaXML: inside beforePrintArgsLogViaXML");
	}

	public void afterPrintArgsLogViaXML() {
		System.out.println("AOPAdvisorsViaXML: inside afterPrintArgsLogViaXML");
	}
}
