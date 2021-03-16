package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationController {

	public AnnotationController() {
		// TODO Auto-generated constructor stub
	}

    @RequestMapping(value="/first", method = RequestMethod.GET)
	public ModelAndView goToFirstPage() {
    	System.out.println("Inside AnnotationController:: goToFirstPage()");
		ModelAndView objMV = new ModelAndView("first");
		objMV.addObject("page", "first sample page");
		objMV.addObject("from", "Annotation first controller");
		objMV.addObject("msg", "Hi, DVK");
		System.out.println("Exiting AnnotationController:: goToFirstPage()");
		return objMV;
	}
    
    @RequestMapping(value="/second", method = RequestMethod.GET)
	public ModelAndView goToSecondPage() {
    	System.out.println("Inside AnnotationController:: goToSecondPage()");
		ModelAndView objMV = new ModelAndView("second");
		objMV.addObject("page", "second sample page");
		objMV.addObject("from", "Annotation first controller");
		objMV.addObject("msg", "Hi, DVK");
		System.out.println("Exiting AnnotationController:: goToSecondPage()");
		return objMV;
	}

}
