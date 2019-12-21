package ExceptionPropogation;

public class TestPropogation {
	public static void main(String[] args) {
	try {	A.o();
		//call inside call insidr call inside .........
	}catch (Exception e) {
		System.out.println("in Test clas...");
		System.out.println(e.getMessage());
	}

}
}
