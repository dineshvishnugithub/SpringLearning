package com.spring.lesson.collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionTester {
	
    public static void main(String[] args) {
		
    	ClassPathXmlApplicationContext objContext = new ClassPathXmlApplicationContext("collectionscontext.xml");
//    	CollectionExample objExample = (CollectionExample)objContext.getBean("listbean");
//    	
//        System.out.println("size of list is :: " + objExample.getObjList().size());
//        
//        int i=0;
//        while(i<objExample.getObjList().size()) {
//        	if(Integer.parseInt((String)objExample.getObjList().get(i))%2!=0)
//        		System.out.println("diplay list LL "  + objExample.getObjList().get(i));
//        	i++;
//        }
    	
    	CollectionExample objExample = (CollectionExample)objContext.getBean("arraybean");
    	
        System.out.println("size of array is :: " + objExample.getObjArray().length);
        
        int i=0;
        while(i<objExample.getObjArray().length) {
           System.out.println("diplay array :: "  + objExample.getObjArray()[i]);
        }
	}
}
