package com.spring.lesson.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeAnnotLifeCycleConfig {
	
	@Bean(name="employeeAnnotLifeCycle")
	public EmployeeAnnotLifecycle getEmployeeAnnotLifecycle() {
		return new EmployeeAnnotLifecycle();
	}

}
