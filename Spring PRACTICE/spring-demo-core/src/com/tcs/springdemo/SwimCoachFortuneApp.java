package com.tcs.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimCoachFortuneApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(SportsConfigurationClass.class);
		//Fetching BEANS through @Bean explicit registration to container Using 
		//Configuration class
		Coach coach = context.getBean(SwimCoach.class);
		System.out.println(coach.getMyDailyWorkDone());
		System.out.println(coach.getMyDailyFortune());
	}
}
