package loosecoupling;

public class Withdraw {
	void moneyDrawn(Atm a) {
		if(a instanceof StateBank) {
			System.out.println("STATE BANK MOONEY CAN BE DRAWN");
		}
		else if(a instanceof HdfcBank) {

			System.out.println("HDFC BANK MONEY CAN BE Drawn");			}
		else {
			System.out.println("INVALID USER");
		}
	}
}