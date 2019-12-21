package objects;

public class Son extends Father{
	Son(){
		super(111,"mowna");
		System.out.println("C,,,sons zero parameterized constructor");
	}
	Son(String name,int age){
		this();
		System.out.println("D,,sons parameterised constructor ");
	}

}
