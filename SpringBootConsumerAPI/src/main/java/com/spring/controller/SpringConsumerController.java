package com.spring.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumerAPI")
public class SpringConsumerController {

	@RequestMapping(value="/consume-rest-with-header", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getEmployeeFromProducer() {
		   //reads output from service of AOP module
	       final String uri = "http://localhost:8085/producerAPI/rest-with-header";
	       
	       HttpHeaders objHeader = new HttpHeaders();
	       objHeader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	       objHeader.set("employeeName", "DineshVishnuKumar C testing as consumer");
	       
	       HttpEntity<String> objEntity = new HttpEntity<String>("parameters", objHeader);
	       
	       RestTemplate objRestTemplate = new RestTemplate();
	       ResponseEntity<String> objResponse = objRestTemplate.exchange(uri, HttpMethod.GET, objEntity, String.class);
	       
	       System.out.println("CustomRestClient: getEmployeeNameFromHeader():: objResponse::: " + objResponse);
	       return objResponse.getBody();
	}
}
