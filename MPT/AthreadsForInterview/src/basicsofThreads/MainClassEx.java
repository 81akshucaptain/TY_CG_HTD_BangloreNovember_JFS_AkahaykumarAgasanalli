package basicsofThreads;

//MULTITHREADING
class MyTask {

	// synchronized
	public void printingDocs(int n, String name) {
		// public void printingDocs(int n, String name) {
		for (int i = 0; i < n; i++) {
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Print docs for :->>" + name + ":" + i);
		}
	}
}

class DummyClass extends Thread {

	MyTask taskRef;

	// CONSTRUCTOR
	public DummyClass(MyTask taskref1) {
		// TODO Auto-generated constructor stub
		this.taskRef = taskref1;
	}

	public DummyClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// synchronized (taskRef) {

		// TODO Auto-generated method stub
		taskRef.printingDocs(3, "NEHA");
		// }
	}

}

class DummyClass3 extends Thread {

	MyTask taskRef;

	// CONSTRUCTOR
	public DummyClass3(MyTask taskref1) {
		// TODO Auto-generated constructor stub
		this.taskRef = taskref1;
	}

	@Override
	public void run() {
		// synchronized (taskRef) {

		// TODO Auto-generated method stub
		taskRef.printingDocs(3, "ABHI");
		// }
	}

}

class DummyClass4 extends Thread {

	MyTask taskRef;

	// CONSTRUCTOR
	public DummyClass4(MyTask taskref1) {
		// TODO Auto-generated constructor stub
		this.taskRef = taskref1;
	}

	@Override
	public void run() {
		// synchronized (taskRef) {

		// TODO Auto-generated method stub
		taskRef.printingDocs(3, "Sahana");
		// }
	}

}

class DummyClass2 extends Thread {

	MyTask taskRef;

	// CONSTRUCTOR
	public DummyClass2(MyTask taskref1) {
		// TODO Auto-generated constructor stub
		this.taskRef = taskref1;
	}

	@Override
	public void run() {
		// synchronized (taskRef) {
		// TODO Auto-generated method stub
		taskRef.printingDocs(3, "CHINNI");
		// }

	}
}

class Jacky implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int c[] = { 1000, 1200, 1003, 1400, 1500 };
		for (int i = 0; i < c.length; i++) {
			System.out.println("Using Jacky :" + c[i]);
		}
	}

}

//If WE ARE EXTENDENING MORE THAN ONE CLASS,Then We use below
//because multiple inheritance is not possible, In order to use Threading
class RunnableExClass extends DummyClass implements Runnable {

	public RunnableExClass(MyTask taskref1) {
		super(taskref1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int c[] = { 10, 12, 13, 14, 15 };
		for (int i = 0; i < c.length; i++) {
			System.out.println("Using Runnable :" + i);
		}
	}

}

public class MainClassEx {

	public static void main(String[] args) {
/*wait() method is primarily used for the inter-thread communication.Counter Methods: notiy(), notifyAll()
 * join() is used for adding sequencing between multiple threads, 
 * one thread starts execution after first thread execution finished, we can not break the waiting imposed by join() method 
 */
		System.out.println("STARTED..........");

		MyTask mRef = new MyTask();

	  /*DummyClass neha = new DummyClass(mRef);
		DummyClass2 chinni = new DummyClass2(mRef);
		DummyClass3 abhi = new DummyClass3(mRef);
		DummyClass4 sahana = new DummyClass4(mRef);*/

		/*IF WE EXECUTED THREADCONCEPT BY EXTENDENDING Thread CLASS then we can call 
		 * directly call t.start();. IF we go for IMPLEMENTING RUNNABLE THEN WE MUST 
		 * PASS THE RUNNAABLE VARIABLE TO Thread class as argument in Constructor 
		 */
		//HOW TO RUN THREADS ???????
		
		//CASE : 1-REFERENCE WITH HELP OF THREAD CLASS TO RUNNABLE 
		Jacky j1 = new Jacky();
		Thread helperForRunnable = new Thread(j1);
		helperForRunnable.start();
		
		//CASE: 2- DIRECT REFERENCE 
		DummyClass3 d33 = new DummyClass3(mRef);
		d33.start();

//		sahana.start();
//		try {
//			sahana.join();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		chinni.start();
//		abhi.start();
//		neha.start();

		// Sync using Join

		System.out.println("ENDED.........");

		/*
		 * MyTask task = new MyTask();
		 * 
		 * DummyClass d = new DummyClass(); d.start();
		 * 
		 * Thread t = new Thread(new Jacky()); t.start();
		 * 
		 * d.setDaemon(true); d.start();
		 * 
		 * int c[] = { 11, 88, 77, 44, 99, 55, 66, 99, 88, 77, 55, 22, 44, 33, 11 };
		 * 
		 * for (int i = 0; i < c.length; i++) { System.out.println(": " + c[i]);
		 * 
		 * }
		 */

	}
}
