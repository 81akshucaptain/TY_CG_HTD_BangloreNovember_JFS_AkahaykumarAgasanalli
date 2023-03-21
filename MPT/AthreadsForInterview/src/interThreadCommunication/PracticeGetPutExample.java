package interThreadCommunication;

class Process {
	boolean setValue = false;
	int num;

	synchronized void ValueSetting(int i) {
		while (setValue) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		num = i;
		setValue = true;
		System.out.println("Value SET : " + num);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		notify();
	}

	synchronized void valueGetting(int i) {
		while (!setValue) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		num = i;
		setValue = false;
		System.out.println("Value Get : " + num);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		notify();
	}

}

class Produce extends Thread {
	Process p0;
	int i = 0;

	public Produce(Process p1) {
		// TODO Auto-generated constructor stub
		this.p0 = p1;
	}

	@Override
	public void run() {

		while (true) {
			p0.ValueSetting(i++);
		}
	}
}

class Consume extends Thread {
	Process p0;
	int i = 0;

	public Consume(Process p1) {
		// TODO Auto-generated constructor stub
		this.p0 = p1;
	}

	@Override
	public void run() {
		while (true) {
			p0.valueGetting(i++);
		}
	}
}

public class PracticeGetPutExample {
	public static void main(String[] args) {
		Process p = new Process();
		Produce pp = new Produce(p);
		pp.start();
		Consume cc = new Consume(p);
		cc.start();
	}
}
