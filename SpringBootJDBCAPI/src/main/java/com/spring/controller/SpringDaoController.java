package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.CustomDao;
import com.spring.pojo.EmployeePOJO;

@RestController
@RequestMapping("springdao")
public class SpringDaoController {
	
	@Autowired
	CustomDao objCustomDao;
	
	@RequestMapping(value="/employee/create", method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody EmployeePOJO objEmployeePojo){
		System.out.println("Inside SpringDaoController: createEmployee:: begin");
		objCustomDao.insert(objEmployeePojo);
		System.out.println("Inside SpringDaoController: createEmployee:: end");
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/employee/enquiry", method=RequestMethod.GET)
	public List<EmployeePOJO> selectAllEmployees(){
		System.out.println("Inside SpringDaoController: selectAllEmployees:: begin");
		return objCustomDao.selectAllEmployees();
	}
	
	@RequestMapping(value="/employee/enquiryBeanProperty", method=RequestMethod.GET)
	public List<EmployeePOJO> selectAllEmployeesBeanPropertyMapper(){
		System.out.println("Inside SpringDaoController: selectAllEmployeesBeanPropertyMapper:: begin");
		return objCustomDao.selectAllEmployeesBeanPropertyMapper();
	}

}
