package com.tcs.springdemo;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getMyDailyWorkDone() {
		return "swim 100 meters daily to work hard";
	}

	@Override
	public String getMyDailyFortune() {
		return fortuneService.getMyFortuneToday();
	}

}
