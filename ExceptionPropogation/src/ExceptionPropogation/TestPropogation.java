package ExceptionPropogation;

public class TestPropogation {
	public static void main(String[] args) {
		try {
			A.o();
			// UNCHECKED EXCEPTIONS will PROPOGATE THE EXCEPTIONS DON'T NEED
			// EXPLICIT "THROWS" KEYWORDS,we can just THROW THE OBJECT SUCCESSIVELY
			// EXCEPTION WILL BE PROPOGATED TO ORIGINAL CALLED FUNCTION
			// call inside call inside call inside .........
		} catch (Exception e) {
			System.out.println("in Test class...");
			System.out.println(e.getMessage());
		}

	}
}
