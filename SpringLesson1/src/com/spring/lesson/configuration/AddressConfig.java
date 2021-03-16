package com.spring.lesson.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {
	
	@Bean(name="addressInfo")
	public Address getAddress() {
		return new Address();
	}

}
