import java.util.ArrayList;

public class CollectionClassMethods {
public static void main(String[] args) {
	ArrayList a1=new ArrayList();
	ArrayList a2=new ArrayList();

	a1.add(22);
	a1.add("akshay");
	a1.add(22.35);
	
	System.out.println(a1);
	System.out.println("********************");
	
	a1.isEmpty();
	a1.contains(22);
	a1.add(2, 1000);
	System.out.println(a1);
	
	System.out.println("the second object completly added");
	a2.add("mowna");
	a2.add(21.2548);
	a2.add(1010101);
	System.out.println(a2);
	
	a1.addAll(a2);
	System.out.println("after adding a2:  "+a1);
}
}
