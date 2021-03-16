package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomController {
   
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String gotToHome() {
	   return "home";
   }
   
   @RequestMapping(value="/profile", method=RequestMethod.GET)
   public String gotToProfile() {
	   return "profile";
   }
}
