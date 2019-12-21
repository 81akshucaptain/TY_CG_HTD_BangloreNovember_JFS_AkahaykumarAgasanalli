package LinkedListExample;

import java.util.Iterator;
import java.util.LinkedList;

public class LLexample {
	public static void main(String[] args) {
		LinkedList<Integer> i1=new LinkedList<Integer>();
		i1.add(8);
		i1.add(6);
		i1.add(9);
		i1.add(1);
		Iterator<Integer> i=i1.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("removes based on the insertions order");
		i1.add(8);
		System.out.println(i1);
		i1.remove(new Integer(8));
		System.out.println(i1);
		System.out.println("**************");
		i1.add(null);
		i1.add(null);
		System.out.println("after adding null value");
		System.out.println(i1);
		
		for (Integer integer : i1) {
			System.out.println("for each elements"+integer);
		}
		for (int j = 0; j < i1.size(); j++) {
	System.out.println("normal for loop: "+i1.get(j));		
		}
	}
}
