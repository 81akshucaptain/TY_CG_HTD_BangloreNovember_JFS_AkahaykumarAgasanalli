package checkedException;

public class IrctcIndia {
	//FOR CHECKED EXCEPTIONS THROWS KEYWORD IS MUST TO USE
	void confimrTicket() throws ClassNotFoundException {
		try {
		Class.forName("Paytm");
		}catch(ClassNotFoundException c1) {
			System.out.println("class not found");
			//hey user u must throw the exception in order to catch it 
			throw c1;
		}
	}

}
