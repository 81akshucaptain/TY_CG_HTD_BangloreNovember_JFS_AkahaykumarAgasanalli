package tcs.interview.methodRef.test.further;

import java.util.function.BiFunction;

interface Sayable2 {
	void say();
}

public class MethodReference {

	public static int add(int a, int b) {
		return a + b;
	}

	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void ThreadStatus() {
		System.out.println("Thread is running...");
	}

	public void display() {
		System.out.println("In Display Function by RUNNABLE MAGIC ---");
	}

	public static void main(String[] args) {
		// CASE:1
		// Referring static method
		Sayable2 sayable = MethodReference::saySomething;
		// Calling interface method
		sayable.say();

		// CASE:2
		Thread t1 = new Thread(MethodReference::ThreadStatus);
		t1.start();
		
		Runnable r2 = () -> {
			new MethodReference().display();
		};
		Thread t2 = new Thread(r2);
		t2.start();

		// Can be used with preDefined functional interface

		BiFunction<Integer, Integer, Integer> adder = MethodReference::add;
		System.out.println("The added value is : " + adder.apply(20, 50));
	}
}