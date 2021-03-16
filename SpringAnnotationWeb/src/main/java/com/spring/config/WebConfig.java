package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

	public WebConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Inside WebConfig:: viewResolver()");
		InternalResourceViewResolver objViewResolver = new InternalResourceViewResolver();
		objViewResolver.setViewClass(JstlView.class);
		objViewResolver.setPrefix("/WEB-INF/views/");
		objViewResolver.setSuffix(".jsp");
		System.out.println("Exiting WebConfig:: viewResolver()");
		return objViewResolver;
	}

}
