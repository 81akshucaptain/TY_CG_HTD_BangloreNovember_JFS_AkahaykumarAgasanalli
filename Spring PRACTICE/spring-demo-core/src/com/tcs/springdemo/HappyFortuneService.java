package com.tcs.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{

	@Override
	public String getMyFortuneToday() {
		return "Have Lucky day Darling";		
	}

}
