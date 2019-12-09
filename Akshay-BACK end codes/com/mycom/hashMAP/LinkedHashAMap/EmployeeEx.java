package com.mycom.hashMAP.LinkedHashAMap;


public class EmployeeEx {
	int sal;
	String name;
	@Override
	public String toString() {
		return "EmployeeEx [sal=" + sal + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sal;
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
		EmployeeEx other = (EmployeeEx) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sal != other.sal)
			return false;
		return true;
	}
	public EmployeeEx(int sal, String name) {
		super();
		this.sal = sal;
		this.name = name;
	}

}
