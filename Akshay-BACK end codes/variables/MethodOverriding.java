package variables;

public class MethodOverriding {
	public static void main(String[] args) {
		Animal a1=new Animal();
		a1.eat();

		Dog d1=new Dog();
		d1.eat();

		Cat c1=new Cat();
		c1.eat();

		Animal a2=new Dog();
		a2.eat();
		
		Animal a3=new Cat();
		a3.eat();
		System.out.println("---------oveloading---------");
		
		MethodOverloading m1=new MethodOverloading();
		m1.eat(5);
		
		Demo1 d2=new Demo1();
		d2.eat(4,5);
		
		Demo2 d3=new Demo2();
		d3.eat("aksha");
		
		MethodOverloading d4=new Demo1();
		d4.eat(5);
		
		MethodOverloading d5=new Demo2();
		d5.eat(5);

		
		
	}
}
