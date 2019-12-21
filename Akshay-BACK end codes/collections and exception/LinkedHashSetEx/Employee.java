package LinkedHashSetEx;

public class Employee {
int empid;
String name;
public Employee(int empid, String name) {
	super();
	this.empid = empid;
	this.name = name;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + empid;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (empid != other.empid)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", name=" + name + "]";
}

}
