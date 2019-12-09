package SetInterface;

import java.util.HashSet;

public class HashSetEx1 {
	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add(55);
		hs.add(95);
		hs.add(23);
		hs.add(11);
		//we cant add hashcode value for null
		//hs.add(null);
		for(Object o:hs) {
			System.out.println(o.hashCode());
			System.out.println(o);
		}
	HashSet<String> hs2=new HashSet<String>();
	hs2.add("akshay");
	hs2.add("mowna");
	hs2.add("kavya");
	hs2.add("manu");
	for (String string : hs2) {
		System.out.println(string.hashCode());
		System.out.println(string);
	}
	
	}
	
	

}
