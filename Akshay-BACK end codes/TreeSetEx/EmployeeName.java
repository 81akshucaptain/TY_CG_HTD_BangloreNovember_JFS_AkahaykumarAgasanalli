package TreeSetEx;

import java.util.Comparator;

public class EmployeeName implements Comparator<EmployeeEx> {

	@Override
	public int compare(EmployeeEx o1, EmployeeEx o2) {

		return o1.name.compareTo(o2.name);
	}

}
