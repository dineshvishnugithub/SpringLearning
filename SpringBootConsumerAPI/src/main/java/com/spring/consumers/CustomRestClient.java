package com.spring.consumers;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CustomRestClient {
	
	public static void main(String args[]) {
//		createEmployees();
		getEmployeeNameFromHeader();
	}
	
	//call service from service of other project deployed in 8084
	public static void createEmployees() {
	   //reads output from service of AOP module
       final String uri = "http://localhost:8084/testEmp/employees/create?name=Dinesh&empId=123";
       
       RestTemplate objRestTemplate = new RestTemplate();
       String returnString = objRestTemplate.getForObject(uri, String.class);
       
       System.out.println("CustomRestClient: createEmployees():: returnString::: " + returnString);
	}
	
	//call service from service of same project using http header deployed in 8085
	public static void getEmployeeNameFromHeader() {
	   //reads output from service of AOP module
       final String uri = "http://localhost:8085/producerAPI/rest-with-header";
       
       HttpHeaders objHeader = new HttpHeaders();
       objHeader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       objHeader.set("employeeName", "DineshVishnuKumar C");
       
       HttpEntity<String> objEntity = new HttpEntity<String>("parameters", objHeader);
       
       RestTemplate objRestTemplate = new RestTemplate();
       ResponseEntity<String> objResponse = objRestTemplate.exchange(uri, HttpMethod.GET, objEntity, String.class);
       
       System.out.println("CustomRestClient: getEmployeeNameFromHeader():: objResponse::: " + objResponse);
	}

}
