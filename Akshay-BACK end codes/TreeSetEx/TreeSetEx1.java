package TreeSetEx;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetEx1 {
public static void main(String[] args) {
	TreeSet ts1=new TreeSet();
	ts1.add(66);
	ts1.add(78);
	ts1.add(2);
	ts1.add(9);
	//ts1.add("akshu"); CLASS CAST EXCEPTION
	//ts1.add(null); NULL POINTER EXCEPTION
	for (Object object : ts1) {
		System.out.println(object);
	}
	//BUG IS HERE...CHECK THE OUTPUT
	System.out.println("_______________++++++++______________");
	TreeSet<StudentEx> ts2=new TreeSet<StudentEx>();
	ts2.add(new StudentEx(12,"mowna"));
	ts2.add(new StudentEx(5,"kavya"));
	ts2.add(new StudentEx(22,"akshu"));
	ts2.add(new StudentEx(66,"manu"));
	
	/*Iterator<StudentEx> it=ts2.iterator();
	while (it.hasNext()) {
		System.out.println(it.next());
	}*/
	for (StudentEx s : ts2) {
		System.out.println("age is :"+s.age+" name "+s.name);
		System.out.println();
	}
}
}
