package LinkedHashSetEx;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetEx3 {
public static void main(String[] args) {
	LinkedHashSet<Employee> e=new LinkedHashSet<Employee>();
	Employee s1=new Employee(22,"akshay");
	Employee s2=new Employee(22,"akshay");
	Employee s3=new Employee(29,"mowna");
	Employee s4=new Employee(27,"kavy");
	e.add(s1);
	e.add(s2);
	e.add(s3);
	e.add(s4);
	
	Iterator i=e.iterator();
	while (i.hasNext()) {
		Object object = (Object) i.next();
		System.out.println(object);
	}
	



	
}
}
