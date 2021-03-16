package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class SecondController extends AbstractController{

	public SecondController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Inside second controller");
		ModelAndView objMV = new ModelAndView("second");
		objMV.addObject("page", "second controller sample page");
		objMV.addObject("from", "second path");
		objMV.addObject("msg", "Hi, DVK second controller page");
		return objMV;
	}

}
