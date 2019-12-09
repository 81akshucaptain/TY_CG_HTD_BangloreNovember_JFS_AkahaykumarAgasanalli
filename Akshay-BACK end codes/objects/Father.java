package objects;

public class Father {
	int age;
	String name;
	Father(){
		System.out.println("A..father zero constructor");
	}
	Father(int age,String name){
		this();
		System.out.println("B..father parameterized constructor");
	}
}
