package ExceptionPropogation;

public class A {
static void o() {
	try{
		B.n();
	}catch (Exception e) {
		System.out.println("in A clas...");
		System.out.println(e.getMessage());
		throw e;
	}
}
}
