package checkedException;

public class A {
public static void main(String[] args) {
	System.out.println("Main started machi");
	try {
		B.l();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
System.out.println("in main handled");	}
}
}
