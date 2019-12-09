package typecasting;

public class TestAnimal {
	public static void main(String[] args) {
		System.out.println("==========upcasting done=======");

		Animal a1=new Dog();
		a1.eat();
		System.out.println("==========downcasting done=======");

		Dog d1=(Dog)a1;
		d1.dog();
		d1.eat();
	}

}
