package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class ThirdController extends AbstractController{

	public ThirdController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Inside third controller");
		ModelAndView objMV = new ModelAndView("third");
		objMV.addObject("page", "second controller third page");
		objMV.addObject("from", "second path");
		objMV.addObject("msg", "Hi, DVK third controller page");
		return objMV;
	}

}
