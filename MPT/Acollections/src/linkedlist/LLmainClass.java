package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

class Student {
	String age;

	public Student(String a) {
		// TODO Auto-generated constructor stub
		this.age = a;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return age;
	}
}

public class LLmainClass {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(10);
		q.add(01);
		q.add(2);
//Object Level Confusion 
		LinkedList<Student> ll2 = new LinkedList<Student>();
		LinkedList<Student> ll3 = new LinkedList<Student>();
		ll2.addFirst(new Student("1000"));
		System.out.println("------" + ll2.getFirst());
		ll3.addFirst(new Student("1000"));
		System.out.println("------" + ll3.getFirst());
		if (ll2.contains(ll3.getFirst())) {
			System.out.println("Pakka");
		} else {
			System.out.println("Wrong");
		}
		// No confusion in Wrapper classes
		LinkedList<Integer> ll5 = new LinkedList<Integer>();
		LinkedList<Integer> ll6 = new LinkedList<Integer>();
		ll5.addFirst(1000);
		System.out.println("------" + ll5.getFirst());
		ll6.addFirst(1000);
		System.out.println("------" + ll6.getFirst());
		if (ll5.contains(ll6.getFirst())) {
			System.out.println("Pakka Integer ");
		} else {
			System.out.println("Wrong Integer");
		}

		System.out.println("Peek element: ->" + q.peek());
		System.out.println("Using Element : ->" + q.element());
		System.out.println("After removing By poll:->" + q.poll() + " : " + q);
	}
}
