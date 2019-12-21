package checkedException;

public class Paytm {
	IrctcIndia i1;

	public Paytm(IrctcIndia i1) {
		super();
		this.i1 = i1;
	}
	void bookTicket() {
		try {
			i1.confimrTicket();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Hey user class is not found plz neter valid class");
		}
	}
}
