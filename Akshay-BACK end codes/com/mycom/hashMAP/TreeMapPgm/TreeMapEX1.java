package com.mycom.hashMAP.TreeMapPgm;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//REUSLT WILL BE IN SORTED ORDER 
public class TreeMapEX1 {
	public static void main(String[] args) {
		TreeMap<Integer,String> t1=new TreeMap<Integer,String>();
		t1.put(2, "supriya");
		t1.put(6, "chaitra");
		t1.put(1, "spurti");
		//keys must be comparable else nullPointer Exception
		//t1.put(null, "pooja");
		Set<Map.Entry<Integer,String>> s1=t1.entrySet();
		for (Map.Entry<Integer, String> entry : s1) {
			System.out.println("value :"+entry.getValue()+" with  key: "+entry.getKey());
			System.out.println("!!!!!!");
		}

	}
}
