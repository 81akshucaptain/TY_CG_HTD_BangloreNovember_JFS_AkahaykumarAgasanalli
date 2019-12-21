package loosecoupling;

public class Atm{
	void withdraw() {
		System.out.println("money withdraw");
	}

}
class StateBank extends Atm{
	void withdraw() {
		System.out.println("IM A STATE BANK HOLDER");
	}
}

class HdfcBank extends Atm{
	void withdraw() {
		System.out.println("IM A hdfc BANK HOLDER");
	}

}