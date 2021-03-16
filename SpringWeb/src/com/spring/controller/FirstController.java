package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView contructFirstModelObject() {
		ModelAndView object = new ModelAndView();
		object.addObject("myname", "Dinesh");
		object.setViewName("intro");
		return object;
	}

}
