import java.util.ArrayList;

public class CollectionToArray {
public static void main(String[] args) {
	ArrayList a1=new ArrayList();
	a1.add(22);
	a1.add("akshay");
	a1.add(22.35);
	
	System.out.println(a1);
	System.out.println("********************");
Object[] a=a1.toArray();
for (int i = 0; i < a.length; i++) {
	System.out.println("array elements are: "+a[i]);
}
}
}
