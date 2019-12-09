package LinkedListExample;

import java.util.LinkedList;

public class LLexample2 {
	public static void main(String[] args) {
		LinkedList<String> l2=new LinkedList<String>();
		l2.add("a");
		l2.add("b");
		l2.add("c");
		l2.add("d");
		System.out.println(l2);
		l2.addFirst("z");
		l2.addLast("W");
		System.out.println("after adding at first and lsat  "+l2);
		System.out.println("----------remove--------");
	l2.remove();
	System.out.println(l2);
	System.out.println("------remove firs and lst-----");
	l2.removeLast();
	l2.removeFirst();
	System.out.println(l2);
	l2.add("a");
	l2.add("c");
	l2.add("b");
	System.out.println(l2);
	System.out.println("------remove first and last occurence");
	l2.removeLastOccurrence("c");
	l2.removeFirstOccurrence("b");
	System.out.println(l2);
	
	}
}
