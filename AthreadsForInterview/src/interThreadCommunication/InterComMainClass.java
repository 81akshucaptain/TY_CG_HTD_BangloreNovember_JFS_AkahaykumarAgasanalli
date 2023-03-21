package interThreadCommunication;

class FactoryOfvalues {
	int num;
	boolean setValue = false;

	public synchronized void put(int num) {
		while (setValue) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		this.num = num;
		this.setValue = true;
		System.out.println("Put: " + num);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		notify();

	}

	public synchronized void get() {
		while (!setValue) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Get: " + num);
		this.setValue = false;
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		notify();
	}
}

class Producer extends Thread {
	FactoryOfvalues factV;

	public Producer(FactoryOfvalues fObj) {
		// TODO Auto-generated constructor stub
		this.factV = fObj;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			factV.put(i++);
		}

	}
}

class Consumer extends Thread {
	FactoryOfvalues factV;

	public Consumer(FactoryOfvalues fObj) {
		// TODO Auto-generated constructor stub
		this.factV = fObj;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			factV.get();
		}

	}
}

public class InterComMainClass {
	public static void main(String[] args) {
		FactoryOfvalues factory = new FactoryOfvalues();
		Producer p = new Producer(factory);
		p.start();
		Consumer c = new Consumer(factory);
		c.start();
	}

}
