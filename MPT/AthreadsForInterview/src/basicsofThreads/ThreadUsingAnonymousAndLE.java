package basicsofThreads;

public class ThreadUsingAnonymousAndLE {
	public static void main(String[] args) {

		// Using Anonymous Runnable class

		Runnable r = new Runnable() {

			@Override
			public void run() { // TODO Auto-generated method stub
				System.out.println("Anonymous RUN thread method");
			}
		};

		Thread t = new Thread(r);
		t.start();

		// Using Lamba expression

		Runnable r2 = () -> {
			System.out.println("Thread using LambaExpression RUN method");
		};

		Thread t2 = new Thread(r2);
		t2.start();
	}
}
