import java.util.ArrayList;

public class CollectionIndexMethod {
public static void main(String[] args) {
	ArrayList a1=new ArrayList();
	a1.add(22);
	a1.add("akshay");
	a1.add(22.35);
	
	System.out.println(a1);
	System.out.println("********************");
	
	ArrayList a2=new ArrayList();

	a2.add("akshay");
	a2.add(21.2548);
	a2.add(1010101);
	a2.addAll(a1);
	System.out.println(a2);
	 System.out.println("index of elements");
	 System.out.println(a2.indexOf(21.2548));
}
}
