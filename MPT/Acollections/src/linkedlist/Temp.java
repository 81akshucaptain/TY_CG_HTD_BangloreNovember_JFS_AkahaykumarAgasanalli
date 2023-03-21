package linkedlist;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Temp {
public static void main(String[] args) {
	String s1="A";
	String s2="A";
	String s3=new String("A");
	
	if(s1==s3) {
		System.out.println(" F  1");
	}else {
		System.out.println(" F 2");
	}
	
	if(s1.equals(s3)) {
		System.out.println(" F 3");
	}else {
		System.out.println(" F 4 ");
	}
	
	HashSet hs=new HashSet();
	hs.add(25);
	hs.add(01);
	hs.add(17);
	hs.add(10);
	hs.add(15);777
	
	
	Collections.sort(hs);
	
	hs.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println(s));
	
	
	
}
}
