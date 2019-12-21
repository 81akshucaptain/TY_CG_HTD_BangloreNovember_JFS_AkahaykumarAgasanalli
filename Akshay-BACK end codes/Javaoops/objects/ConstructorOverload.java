package objects;

public class ConstructorOverload {
	int age;
	String name;
	double salary;
	ConstructorOverload(int age){
		this.age=age;
	}
	ConstructorOverload(String name,double salary){
		this.name=name;
		this.salary=salary;
	}

}
