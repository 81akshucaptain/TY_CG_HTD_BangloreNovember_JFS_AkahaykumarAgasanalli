
public class TestInstance {
public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	NewInstanceExample n=new NewInstanceExample("akshaykumar");
	Class d=n.getClass();
	NewInstanceExample n2=(NewInstanceExample)d.newInstance();
	System.out.println(d);
	System.out.println("the first object:"+n+"::second object :: "+n2);
	System.out.println(n.name+" ::: "+n2.name);
	Class c=Class.forName("NewInstanceExample");
	System.out.println(c);
	//SO there is no difference between class.for/name and getClass methods both returns the  class name itself
	NewInstanceExample n3=(NewInstanceExample)c.newInstance();
	System.out.println("the new insatnce address:::"+"the name is :::"+n3.name);
	
}
}
