package com.spring.lesson.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycleSuperClass implements BeanNameAware, ApplicationContextAware, InitializingBean{
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside afterPropertiesSet() called by :: " + this.getClass());
		System.out.println(" ");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Inside setApplicationContext:: apllication context :: " +  arg0);
		System.out.println(" ");
	}

	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("Inside setBeanName:: Bean name :: " + arg0);
		System.out.println(" ");
	}
}
