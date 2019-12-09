package com.mycom.hashMAP.TreeMapPgm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//COLLETION INSIDE COLLECTION 
public class CollectionInsideCollectionTreeMap {
public static void main(String[] args) {
	ArrayList<StudentEx> a2=new ArrayList<StudentEx>();
	a2.add(new StudentEx(12,"mowna"));
	
	ArrayList<StudentEx> a1=new ArrayList<StudentEx>();
	a1.add(new StudentEx(22,"akshu"));
	
		ArrayList<StudentEx> a3=new ArrayList<StudentEx>();
	a3.add(new StudentEx(11,"kavya"));
	
	
	TreeMap<String,ArrayList> t1=new TreeMap<String,ArrayList>();
	t1.put("2nd std", a2);
	t1.put("3rd std", a3);
	t1.put("1st std", a1);

	
	Set<Map.Entry<String,ArrayList>> s1=t1.entrySet();
	for (Map.Entry<String, ArrayList> entry : s1) {
		System.out.println(entry.getValue()+"this guy is "+entry.getKey());
		System.out.println("---------------------");
	}
}
}
