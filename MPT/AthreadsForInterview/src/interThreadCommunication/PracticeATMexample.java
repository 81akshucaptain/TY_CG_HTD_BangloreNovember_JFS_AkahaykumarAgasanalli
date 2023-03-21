package interThreadCommunication;

class ATMex {
	int balance = 900;

	synchronized void withdraw(int amount) {
		if (balance < amount) {
			System.out.println("Less Balance-DEPOIST amount ----!");
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
			balance = balance - amount;
			System.out.println("Amount withdrawed Successfully");
			System.out.println("BALANCE:--" + balance);
		}

	}

	synchronized void deposit(int amount) {
		
			System.out.println("Depositing...amount -> " + amount);
		balance = balance + amount;
		System.out.println("Deposit SUCCESFULLY...!");
		notify();
	}
}

public class PracticeATMexample {
	public static void main(String[] args) {
		ATMex a = new ATMex();
		Thread t1 = new Thread() {
			public void run() {
				a.withdraw(1000);
			}
		};
		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				a.deposit(1000);
			}
		};
		t2.start();

	}
}
