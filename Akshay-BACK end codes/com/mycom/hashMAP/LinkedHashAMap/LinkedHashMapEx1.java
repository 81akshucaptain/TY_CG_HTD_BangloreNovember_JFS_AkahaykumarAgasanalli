package com.mycom.hashMAP.LinkedHashAMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//MAINTAINS THE INSERTION ORDER 
public class LinkedHashMapEx1 {
public static void main(String[] args) {
	LinkedHashMap<String,Integer> l1=new LinkedHashMap<String,Integer>();
	l1.put("btm",2011 );
	l1.put("null", 2012);
	l1.put("oar", 2013);
	
	Set<Map.Entry<String,Integer>> s1=l1.entrySet();
	for (Map.Entry<String, Integer> entry : s1) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		System.out.println("------------------");
	}
	System.out.println("size of llH:"+l1.size());
	System.out.println("the keys are:"+l1.keySet());
	Boolean b=l1.containsKey("btm");
	System.out.println("? key btm exist:? "+b);
}
}
