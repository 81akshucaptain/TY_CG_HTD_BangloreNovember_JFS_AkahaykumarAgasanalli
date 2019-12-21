package ExceptionPropogation;

public class C {
	static void m() {
		try {
			System.out.println("in c class");
		System.out.println(0/0);
	}catch(ArithmeticException e) {
		String s=e.getMessage();
		System.out.println(s);
		throw e;
	}

}
}
