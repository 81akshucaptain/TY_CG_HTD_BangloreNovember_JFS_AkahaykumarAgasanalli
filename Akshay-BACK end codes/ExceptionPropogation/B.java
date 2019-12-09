package ExceptionPropogation;

public class B {
	static void n() {
		try{
			C.m();
		}catch (Exception e) {
			System.out.println("in B clas...");
			System.out.println(e.getMessage());
			throw e;
		}
	}

}
