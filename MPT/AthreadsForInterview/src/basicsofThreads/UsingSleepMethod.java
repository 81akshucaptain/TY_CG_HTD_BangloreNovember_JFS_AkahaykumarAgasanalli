package basicsofThreads;

public class UsingSleepMethod {
	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());
		String[] messages = { "1", "2", "3","4","5","6","7","8"};

		Runnable r = () -> {
			System.out.println(Thread.currentThread().getName());

			for (String string : messages) {
				System.out.println(string);
				try {
					Thread.sleep(10);

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};// END OF LE

		Thread t0 = new Thread(r);
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t0.start();
		
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		t2.start();

	}
}
