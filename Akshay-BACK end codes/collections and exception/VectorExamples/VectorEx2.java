package VectorExamples;

import java.util.Vector;

public class VectorEx2 {
public static void main(String[] args) {
	Vector v1=new Vector();
	System.out.println("size: "+v1.size());
	System.out.println("capcity"+v1.capacity());
	v1.add(58);
	v1.add(23);
	v1.add(47);
	v1.add(96);
System.out.println("size"+v1.size());
System.out.println("capcity"+v1.capacity());
v1.trimToSize();
System.out.println("after triming size"+v1.size());
System.out.println("after triminig capcity"+v1.capacity());
v1.setSize(10);
System.out.println("extra size will be added with null setiing size to 10: ");
System.out.println("size"+v1.size());
System.out.println(v1);
v1.add(200);
System.out.println("size"+v1.size());
v1.set(5,5000);
System.out.println("after adding 5000 @ 5 th position: "+v1);

}
}
