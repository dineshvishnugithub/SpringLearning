package com.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.spring.dao.SpringCustomDao;
import com.spring.pojo.EmployeeFilePOJO;

import oracle.jdbc.driver.OracleBlob;

@Controller
public class SpringDaoController {
	
	@Autowired
	SpringCustomDao objDao;
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String getWelcomeView(@RequestParam(value="name", defaultValue="TestName", required=false) String name, Model mo) {
		System.out.println("SpringDaoController:: getWelcomeView: name:::" + name);
		mo.addAttribute("name", name);
		return "welcome";
	}
	
	@RequestMapping(value="/fileupload", method=RequestMethod.GET)
	public String getFileUploadView(@RequestParam(value="name", defaultValue="TestName", required=false) String name, Model mo) {
		System.out.println("SpringDaoController:: getFileUploadView: name:::" + name);
		mo.addAttribute("name", name);
		return "fileupload";
	}
	
	@RequestMapping(value="/fileuploadPost1", method=RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	public String getFileUploadPost1(@RequestBody Object body, @RequestParam(value="name", defaultValue="TestName", required=false) String name, @RequestParam(value="file", required=false) MultipartFile stream) {
		System.out.println("SpringDaoController:: getFileUploadPost: name:::" + name);
		System.out.println("SpringDaoController:: getFileUploadPost: stream:::" + stream);
		return "fileupload";
	}
	
	@RequestMapping(value="/fileuploadPost2", method=RequestMethod.POST)
	public String getFileUploadPost2(@RequestParam(value="name", defaultValue="TestName", required=false) String name, @RequestParam(value="filename", required=false) String filename) {
		System.out.println("SpringDaoController:: getFileUploadPost: name:::" + name);
		System.out.println("SpringDaoController:: getFileUploadPost: filename:::" + filename);
		return "fileupload";
	}
	
	@RequestMapping(value="/fileuploadPost3", method=RequestMethod.POST)
	public String getFileUploadPost3(@RequestBody EmployeeFilePOJO employee) {
		System.out.println("SpringDaoController:: getFileUploadPost: name:::" + employee.getName());
		System.out.println("SpringDaoController:: getFileUploadPost: filename:::" + employee.getFileName());
		return "fileupload";
	}
	
	@RequestMapping(value="/fileuploadPost", method=RequestMethod.POST)
	public String getFileUploadPost(@RequestBody String payload) {
		System.out.println("SpringDaoController:: getFileUploadPost: payload:::" + payload);
//		HashMap<String, Object> payload1 = (HashMap<String, Object>) payload[0];
//		payload1.entrySet();
		String[] splitString = payload.split("&");
		System.out.println("SpringDaoController:: getFileUploadPost: name:::" + splitString[0]);
		System.out.println("SpringDaoController:: getFileUploadPost: filename:::" + splitString[1]);
		return "fileupload";
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(1000000000);
	    return multipartResolver;
	}
	
	@RequestMapping(value="/fileuploadPost4", method=RequestMethod.POST, consumes=MediaType.ALL_VALUE)
	public String getFileUploadPost4(@RequestParam(value="name", defaultValue="TestName", required=false) String name, @RequestParam(value="file", required=false) MultipartFile stream) throws SerialException, SQLException {
		System.out.println("SpringDaoController:: getFileUploadPost: name:::" + name);
		System.out.println("SpringDaoController:: getFileUploadPost: stream:::" + stream);
		try {
			objDao.insert(name,stream.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			return "fileError";
		}
		return "fileSuccess";
	}
}
