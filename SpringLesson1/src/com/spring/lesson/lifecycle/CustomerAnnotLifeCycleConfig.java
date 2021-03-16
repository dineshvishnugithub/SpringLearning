package com.spring.lesson.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerAnnotLifeCycleConfig {
	
	@Bean(name="customerAnnotLifeCycle")
	public CustomerAnnotLifecycle getCustomerAnnotLifecycle() {
		return new CustomerAnnotLifecycle();
	}

}
