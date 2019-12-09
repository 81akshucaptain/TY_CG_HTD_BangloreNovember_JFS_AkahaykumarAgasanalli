package objectexample;

public class MainDog {
	public static void main(String arg[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Dog d1=new Dog("pinky");
		Class c1=d1.getClass();
		//it will return type of Object,so downcast to class Dog  
		Dog d2=(Dog)c1.newInstance();
		System.out.println(c1);
		System.out.println(d2.name);
		Class c2=Class.forName("Dog");
		System.out.println(c2);
		Dog d3=(Dog)c2.newInstance();//just work on default package to overcome this exception
		System.out.println(d3.name);
		}
}
