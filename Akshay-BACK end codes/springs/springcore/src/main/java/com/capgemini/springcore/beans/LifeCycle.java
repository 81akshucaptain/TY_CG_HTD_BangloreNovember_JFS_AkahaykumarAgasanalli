package com.capgemini.springcore.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycle {
	public static void main(String[] args) {
		//ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

		Hello hello=context.getBean(Hello.class);
		System.out.println(hello.getMsg());
		System.out.println(hello.getCount());
		//to destroy the objects
		context.close();
	}
}
