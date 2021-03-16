package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.JDBCPersistDAO;
import com.spring.pojo.EmployeePOJO;

@Controller
public class SpringController {
	
	@Autowired
	JDBCPersistDAO objDao;

	public SpringController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView getEmployeesForm() {
		return new ModelAndView("employees", "employeesdet", new EmployeePOJO());
	}
    
	@RequestMapping(value="/saveEmployeeDet", method=RequestMethod.POST)
	public String insertEmployees(@ModelAttribute("employeesdet") EmployeePOJO objEmpDet, BindingResult objBind, ModelMap objModel) {
		if(objBind.hasErrors()) {
			return "error";
		}
		objDao.insert(objEmpDet);
		objModel.addAttribute("employeeId", objEmpDet.getEmployeeId());
		objModel.addAttribute("firstName", objEmpDet.getFirstName());
		objModel.addAttribute("lastName", objEmpDet.getLastName());
		objModel.addAttribute("email", objEmpDet.getEmail());
		objModel.addAttribute("phoneNumber", objEmpDet.getPhoneNumber());
		objModel.addAttribute("hireDate", objEmpDet.getHireDate());
		objModel.addAttribute("jobID", objEmpDet.getJobID());
		objModel.addAttribute("salary", objEmpDet.getSalary());
		objModel.addAttribute("commissionPct", objEmpDet.getCommissionPct());
		objModel.addAttribute("managerId", objEmpDet.getManagerId());
		objModel.addAttribute("departmentId", objEmpDet.getDepartmentId());
		return "empSuccess";
	}
}
