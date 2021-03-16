package com.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		
		/*
	    <servlet>
	        <servlet-name>firstcontroller</servlet-name>
	        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	        <load-on-startup>1</load-on-startup>
	    </servlet>
	    <servlet-mapping>
	        <servlet-name>firstcontroller</servlet-name>
	        <url-pattern>/</url-pattern>
	    </servlet-mapping>
	    */
		System.out.println("Inside AppInitializer:: onStartup()");
		AnnotationConfigWebApplicationContext objCtx = new AnnotationConfigWebApplicationContext();
		objCtx.register(WebConfig.class);
		objCtx.setServletContext(container);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(objCtx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		System.out.println("Exiting AppInitializer:: onStartup()");
	}

}
