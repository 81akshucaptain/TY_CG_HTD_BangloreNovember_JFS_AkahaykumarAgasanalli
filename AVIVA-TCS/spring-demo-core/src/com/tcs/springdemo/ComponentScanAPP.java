package com.tcs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentScanAPP {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("AnnotationApplicationContext.xml");
		Coach coach = context.getBean(TennisCoach.class);
		System.out.println(coach.getMyDailyWorkDone());
	}
}
