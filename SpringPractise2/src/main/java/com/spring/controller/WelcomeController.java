package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WelcomeController extends AbstractController{

	public WelcomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Inside welcome controller");
		ModelAndView objMV = new ModelAndView("welcome");
		objMV.addObject("page", "welcome controller sample page");
		objMV.addObject("from", "welcome path");
		objMV.addObject("msg", "Hi, DVK welcome controller page");
		return objMV;
	}

}
