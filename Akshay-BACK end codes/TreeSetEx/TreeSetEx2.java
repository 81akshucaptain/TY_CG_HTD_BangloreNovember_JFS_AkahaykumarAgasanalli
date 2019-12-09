package TreeSetEx;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetEx2 {
public static void main(String[] args) {
	EmployeeAge e1=new EmployeeAge();
	EmployeeName e2=new EmployeeName();
	
	TreeSet<EmployeeEx> ts2=new TreeSet<EmployeeEx>(e2);
	ts2.add(new EmployeeEx(12,100,"mowna"));
	ts2.add(new EmployeeEx(5,200,"kavya"));
	ts2.add(new EmployeeEx(22,50,"akshu"));
	ts2.add(new EmployeeEx(66,25,"manu"));
	for (EmployeeEx ex : ts2) {
		System.out.println("name: "+ex.name+" age: "+ex.age+"  "+ "sal: "+ex.sal);
		
	}

}
}
