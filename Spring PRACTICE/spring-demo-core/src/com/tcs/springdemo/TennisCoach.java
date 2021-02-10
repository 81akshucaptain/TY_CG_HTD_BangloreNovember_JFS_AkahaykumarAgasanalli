package com.tcs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
@Component
/*
 * There will be default ID using class name with lower case or you can choose
 * your own name
 */
public class TennisCoach implements Coach {

	@Autowired
	//WHEN THER IS CONFLICT BEETWEN MULTIPLE BEANS TO AUTOWIRING THEB
	//WILL GONE USE THIS QUALIFIER TO RESOLVE IT
	
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	@Value("${email}")
	private String email;
	@Value("${team}")
	private String team;

	
	
	/*
	 * AUTOWIRING USING CONSTRUCTOR
	 * 
	 * @Autowired public TennisCoach(FortureService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 * 
	 */

	/*
	 * AUTOWIRING USING SETTER METHOD
	 * 
	 * @Autowired public void setFortuneService(FortureService theFortuneService) {
	 * this.fortuneService = theFortuneService;
	 * System.out.println("This is Setter method for Autowiring"); }
	 */

	/*
	 * AUTOWIRING USING NORMAL METHOD
	 * 
	 * @Autowired public void anyMethodFortuneService(FortureService
	 * theFortuneService) { this.fortuneService = theFortuneService;
	 * System.out.println("This is Normal method for Autowiring"); }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getMyDailyFortune() {
		return fortuneService.getMyFortuneToday();
	}

	@Override
	public String getMyDailyWorkDone() {
		// TODO Auto-generated method stub
		return "Let me practice tennis in ground";
	}

}
