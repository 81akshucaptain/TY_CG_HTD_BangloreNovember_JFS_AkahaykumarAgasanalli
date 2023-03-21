package tcs.interview.defaultstaticmethods;

interface Interface1 {

	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}

	static void print(String str) {
		System.out.println("Printing " + str);
	}

	// trying to override Object method gives compile-time error as
	// "A default method cannot override a method from java.lang.Object"

//	default String toString(){
//		return "i1";
//	}

}

interface Interface2 {

	void method2();

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}

}

public class DefaultAndStaticMethodsEx implements Interface1, Interface2 {
	// CLASS 'wont compile as DefaultAndStaticMethodsEx
	// must override the default method log else error

	public static void main(String[] args) {
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub

	}

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Interface1.super.log(str);
	}

	
}
