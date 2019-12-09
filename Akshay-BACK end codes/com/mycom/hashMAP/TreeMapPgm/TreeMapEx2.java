package com.mycom.hashMAP.TreeMapPgm;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx2 {
	public static void main(String[] args) {
		//SORTS BASED ON THE AGE
		BasedOnAge b1=new BasedOnAge();
		//SORTS BASED ON NAME
		BasedOnName b2=new BasedOnName();
		//PASS THE OBJECTS TO TREEMAP
		TreeMap<StudentEx,String> t1=new TreeMap<StudentEx,String>(b2);
		t1.put(new StudentEx(7,"aavya"), "3rd std");
		t1.put(new StudentEx(6,"mowna"), "2nd std");
		t1.put(new StudentEx(5,"xkshu") , "1st std");
		Set<Map.Entry<StudentEx,String>> s1=t1.entrySet();
		for (Map.Entry<StudentEx, String> entry : s1) {
			System.out.println(entry.getKey()+" this student is: "+entry.getValue());
			System.out.println("++++++++++");
		}
	}
}
