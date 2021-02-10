package com.tcs.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String data[] = {
			"Good morning HSM", 
			"Good afternoon HSM", 
			"Good night HSM",
			"malkoro HSM" };
	
	private Random random=new Random();

	@Override
	public String getMyFortuneToday() {
		int index=random.nextInt(data.length);
		String value=data[index];
		return value;
	}
}
