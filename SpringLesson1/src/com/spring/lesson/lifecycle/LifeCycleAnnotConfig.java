package com.spring.lesson.lifecycle;

import org.springframework.context.annotation.Import;

@Import({EmployeeAnnotLifeCycleConfig.class})
public class LifeCycleAnnotConfig {

	public LifeCycleAnnotConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
}
