package TreeSetEx;

import java.util.Comparator;

public class EmployeeAge implements Comparator<EmployeeEx> {

	@Override
	public int compare(EmployeeEx o1, EmployeeEx o2) {
		if(o1.age>o2.age) {
			return 1;
		}
		else if(o1.age<o2.age) {
			return -1;
		}
		else 
			{
			return 0;
			}

	}
}
