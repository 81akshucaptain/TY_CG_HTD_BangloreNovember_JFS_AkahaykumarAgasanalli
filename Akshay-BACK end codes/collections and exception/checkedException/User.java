package checkedException;

public class User {
	public static void main(String[] args) {
		System.out.println("main started");
		IrctcIndia i=new IrctcIndia();

		Paytm p=new Paytm(i);
		p.bookTicket();
		System.out.println("main ended");

	}

}
