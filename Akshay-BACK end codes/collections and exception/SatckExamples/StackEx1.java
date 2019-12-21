package SatckExamples;

import java.util.Stack;

public class StackEx1 {
public static void main(String[] args) {
	Stack s=new Stack();
	s.push(56);
	s.add(65);
	s.add(98);
	s.push(98);
	System.out.println("the elements ar e: "+s);
	s.pop();
System.out.println("elements are "+s);
System.out.println("peek element is: "+s.peek());
System.out.println("find the elemnt 56 "+s.search(new Integer(56)));
}
}
