package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Hello;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		Hello hello=context.getBean(Hello.class);
		System.out.println(hello.getMsg());
	}
}
