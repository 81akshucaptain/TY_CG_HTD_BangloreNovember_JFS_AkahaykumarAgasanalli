package basicsofThreads;

class MyTask1 {
	public void display() {
		for (int i = 0; i < 30; i++) {
			System.out.println("Thread Name is:" + Thread.currentThread().getName());
		}
	}
}

class ThreadingNo1 extends Thread {
	MyTask1 myT;

	public ThreadingNo1(MyTask1 myT) {
		super();
		this.myT = myT;
	}

	@Override
	public void run() {
		System.out.println("in ThreadingNo1_____________");
		myT.display();
	}
}

class ThreadingNo2 extends Thread {
	MyTask1 myT;

	public ThreadingNo2(MyTask1 myT) {
		super();
		this.myT = myT;
	}

	@Override
	public void run() {
		System.out.println("in ThreadingNo2_____________");
		myT.display();
	}
}

public class MeTestingThread {
	public static void main(String[] args) {
		MyTask1 mtRef = new MyTask1();
		ThreadingNo1 t1 = new ThreadingNo1(mtRef);
		ThreadingNo2 t2 = new ThreadingNo2(mtRef);

		t1.run();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t2.run();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
