package VectorExamples;

import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		Vector v1=new Vector();
		v1.add(58);
		v1.add(23);
		v1.add(47);
		v1.add(96);
		System.out.println(v1);
		v1.remove(new Integer(58));
		System.out.println("elemtns after removing 58: "+v1);
		v1.set(2, 100);
		System.out.println("after set: at 2"+v1);
		for (int i = 0; i < v1.size(); i++) {
			System.out.println(v1.get(i));
		}
		
	}
}
