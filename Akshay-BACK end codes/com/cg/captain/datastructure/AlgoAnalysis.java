package com.cg.captain.datastructure;

import java.time.Duration;
import java.time.Instant;

public class AlgoAnalysis {
	public static void main(String[] args) {
		long l=90000L;
		System.out.println(addUpto(l));
		System.out.println(addUuptoQuick(l));
		countingDuration();
		countingDuration2();

	}
	static long addUpto(long l) {

		long total=0L;

		for (int i = 0; i < 9999L; i++) {
			total=total+i;
		}
		return total;
	}
	public static long addUuptoQuick(long num) {
		return  num*(num+1)/2;
	}
	public static void countingDuration() {
		long num=9921L;
		Instant start=Instant.now();
		System.out.println("addUpto: "+addUpto(num));
		Instant end=Instant.now();
		Long duration=Duration.between(start,end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("addUpto takes : "+seconds);

	}
	public static void countingDuration2() {
		long num=9921L;
		Instant start=Instant.now();
		System.out.println("addUpto: "+addUuptoQuick(num));
		Instant end=Instant.now();
		Long duration=Duration.between(start,end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("addUptoQuick takes : "+seconds);

	}
}
