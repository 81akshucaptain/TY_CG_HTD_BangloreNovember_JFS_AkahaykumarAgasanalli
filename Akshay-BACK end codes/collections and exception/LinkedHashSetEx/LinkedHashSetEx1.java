package LinkedHashSetEx;

import java.util.LinkedHashSet;

public class LinkedHashSetEx1 {
	public static void main(String[] args) {
		//maintains INSERTION ORDER
		LinkedHashSet lhs=new LinkedHashSet();
		lhs.add(56);
		lhs.add(92);
		lhs.add(82);
		lhs.add(82);
		lhs.add(82);
		lhs.add(null);
		lhs.add(null);
		for (Object object : lhs) {
			System.out.println(object);
		}
		LinkedHashSet<String> lhs2=new LinkedHashSet<String>();
		lhs2.add("akshu");
		lhs2.add("mowna");
		lhs2.add("akshu");
		for (String string : lhs2) {
			System.out.println(string);
		}
		

	}
}