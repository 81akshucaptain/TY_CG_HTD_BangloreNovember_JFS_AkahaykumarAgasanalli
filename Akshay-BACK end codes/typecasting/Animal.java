package typecasting;

public class Animal {
	void eat() {
		System.out.println("im in ANimal class");
	}
}
class Dog extends Animal {
	int x=10;
	void eat() {
		System.out.println("eat() acessed from Animal class reff. OVERRIDED");
	}
	void dog()
{
		System.out.println("in dog class");}
}
