package objects;

public class TestConstructor {
	public static void main(String[] args) {
	ConstructorOverload c1=new ConstructorOverload(45);
	ConstructorOverload c2=new ConstructorOverload("akshay",41.25);
	System.out.println(c2.name+" "+c2.salary);
	System.out.println(c1.age);
	}
}
