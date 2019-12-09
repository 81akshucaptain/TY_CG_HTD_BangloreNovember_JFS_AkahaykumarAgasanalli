package com.mycom.hashMAP.LinkedHashAMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapEx2 {
	public static void main(String[] args) {
		LinkedHashMap<Integer,EmployeeEx> l1=new LinkedHashMap<Integer,EmployeeEx>();
		l1.put(5, new EmployeeEx(1000,"akshu"));
		l1.put(1, new EmployeeEx(2000,"kavya"));
		l1.put(3, new EmployeeEx(500,"kavy"));
		System.out.println(l1.get(5));
		System.out.println("=================");

		//TO GET THE VALUE BASED ON TH EKAYS;
		Set<Map.Entry<Integer,EmployeeEx>> s=l1.entrySet();
		for (Map.Entry<Integer, EmployeeEx> entry : s) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
			System.out.println("____________");
		}


	}
}
