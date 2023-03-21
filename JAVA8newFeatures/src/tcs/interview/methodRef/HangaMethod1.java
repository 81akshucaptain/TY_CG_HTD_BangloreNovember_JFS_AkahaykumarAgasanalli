package tcs.interview.methodRef;

interface Sayable {
	void say();
}

public class HangaMethod1 {
	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = HangaMethod1::saySomething;
		// Calling interface method
		sayable.say();
	}

	public static void jack() {
		System.out.println("Thread 1 Is Runnning ");
	}

//	public static void main(String[] args) {
//		Thread t = new Thread(HangaMethod1::jack);
//		t.start();
//	}
}