package com.tcs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AnnotationApplicationContext.xml");
		// Coach coach = context.getBean(TennisCoach.class);
        //bcz we cant access the setter and getters using caoch interface
		TennisCoach coach = context.getBean(TennisCoach.class);
		System.out.println(coach.getMyDailyWorkDone());
		System.out.println(coach.getMyDailyFortune());
		// AFTER PROPETIES FILE INSERTING
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
	}
}
