package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class TestAL {
	public static void main(String[] args) {
		
		String s1 = "A", s2 = "a", s3 = "b";
		s1.toLowerCase();
		s3.replace('b', 'a');
		System.out.println(s1.equals(s2) + "," + (s2.equals(s3)));

		ArrayList al = new ArrayList();
		al.add("b");
		al.add("z");
		al.add("c");
		al.add("d");
		TreeSet<String> s = new TreeSet<String>();
		//s.add(10);
		Collections.sort(al);

		System.out.println("Output:   " + al);
	}
}
