package VectorExamples;

import java.util.Vector;

public class VectorEx3 {
	public static void main(String[] args) {
		Vector v2=new Vector();
		v2.addElement(56);
		v2.addElement(98);
		v2.addElement(91);
		v2.addElement(82);
		v2.add(94);
		System.out.println(v2);
		v2.removeElement(new Integer(56));
		System.out.println("after removing element"+v2);
		v2.removeElementAt(2);
		System.out.println("after removing element at 2: "+v2);
		Object[] o1=new Object[v2.size()];
		v2.copyInto(o1);
		for (int i = 0; i < o1.length; i++) {
			System.out.println("th array elements are: "+o1[i]);
		}
		v2.removeAllElements();
		System.out.println("after removing all elemnts"+v2);
		
		Vector v1=new Vector();
		v1.addElement(5);
		v1.addElement(8);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.trimToSize();
		System.out.println("after trimining: "+v1.size());
		System.out.println("after triming: "+v1.capacity());
		System.out.println("setted to ensure cap=6 and setsize=8: ");
		v1.ensureCapacity(6);
		v1.setSize(8);
		System.out.println("after incresesing : "+v1.size());
		System.out.println("after increasing doubles the size i.e cc*2 size: "+v1.capacity());
		System.out.println(v1);
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}