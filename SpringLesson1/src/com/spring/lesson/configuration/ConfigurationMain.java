package com.spring.lesson.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration // this is default to be provided
@Import({AddressConfig.class, EducationConfig.class}) // this is to to import the configuration class
@ImportResource({"configurationTesting.xml"})  // this is import the config xml
@ComponentScan(basePackages="com.spring.lesson.*")
public class ConfigurationMain {
	
   public ConfigurationMain() {
	   
   }
   
}
