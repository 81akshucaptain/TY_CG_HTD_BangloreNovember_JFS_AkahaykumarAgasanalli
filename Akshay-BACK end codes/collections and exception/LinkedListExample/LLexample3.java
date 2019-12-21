package LinkedListExample;

import java.util.LinkedList;

public class LLexample3 {
	public static void main(String[] args) {
		LinkedList l3=new LinkedList();
		l3.add(23);
		l3.add(5);
		l3.add(98);
		l3.add(47);
		System.out.println("LL elements is"+l3);

		System.out.println("---------PEEK,fisr,last....GIVE ON BASED PEEK...");
		System.out.println(l3.peek());
		System.out.println("LL peeL elements is"+l3);
		System.out.println(l3.peekLast());
		System.out.println("LL peekf elements is"+l3);
		System.out.println(l3.peekFirst());


		System.out.println("LL elements is"+l3);
		System.out.println("----------pol,first,last...GIVE ELEMENTS BASED ON POLL-----------");
		System.out.println(l3.poll());
		System.out.println("LL polF elements is"+l3);
		System.out.println(l3.pollFirst());
		System.out.println("LL polL elements is"+l3);
		System.out.println(l3.pollLast());
		System.out.println("LL pol elements is"+l3);

		System.out.println("LL elements after peek and poll: "+l3);
		System.out.println("----------offer,f,l-------INSERT AT GIVEN POSITION");
		System.out.println(l3.offer(30));
		System.out.println("after offer l3 is: "+l3);
		System.out.println(l3.offerFirst(45));
		System.out.println("after offerF l3 is: "+l3);
		System.out.println(l3.offerLast(66));
		System.out.println("after offerL l3 is: "+l3);
System.out.println("-------------push..pop------------");
		LinkedList l4=new LinkedList();
		l4.add(88);
		l4.add(45);
		l4.add(95);
		l4.add(23);
		System.out.println("LL4 elements are: "+l4);
		l4.pop();
		System.out.println("after poping "+l4);
		l4.push(77);
		System.out.println("after pushing "+l4);
		System.out.println(l4.element());
		System.out.println("after all operations remaining elements are: "+l4);



	}
}
