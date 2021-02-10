package com.tcs.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoConfigurationApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new 
				AnnotationConfigApplicationContext(SportsConfigurationClass.class);
		// Coach coach = context.getBean(TennisCoach.class);
        //because we can't access the setter and getters using coach interface
		TennisCoach coach = context.getBean(TennisCoach.class);
		System.out.println(coach.getMyDailyWorkDone());
		System.out.println(coach.getMyDailyFortune());
		// AFTER PROPETIES FILE INSERTING
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
	}
}
