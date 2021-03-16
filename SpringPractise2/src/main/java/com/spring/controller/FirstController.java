package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class FirstController extends AbstractController {

	public FirstController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Inside first controller");
		ModelAndView objMV = new ModelAndView("first");
		objMV.addObject("page", "first controller sample page");
		objMV.addObject("from", "wildcard first controller");
		objMV.addObject("msg", "Hi, DVK");
		return objMV;
	}

}
