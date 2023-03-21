package interThreadCommunication;

class ATM {
	int amount = 1000;

	synchronized void withdraw(int amount) {
		System.out.println("Withdraw Started..... ");
		if (this.amount < amount) {
			System.out.println("Less Balance Please deposit amount ");

			try {
				System.out.println("Asking For deposits:");
				wait();

			} catch (Exception e) {
				// TODO: handle exception
			}
			this.amount = this.amount - amount;
			System.out.println("Amount left in account:" + this.amount);
		}

	}

	synchronized void deposit(int amount) {
		System.out.println("Depositing the amount....");
		this.amount = this.amount + amount;
		System.out.println("Deposisted :Total:--" + this.amount);
		notify();
	}
}

public class MeTestingInterCommunication {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread t1 = new Thread() {
			public void run() {
				atm.withdraw(1001);
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				atm.deposit(2000);
			}
		};
		t2.start();
	}
}
