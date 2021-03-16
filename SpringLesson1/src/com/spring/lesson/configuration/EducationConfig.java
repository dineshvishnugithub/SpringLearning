package com.spring.lesson.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EducationConfig {
	
	@Bean(name="educationInfo")
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Education getEducation() {
		return new Education();
	}

}
