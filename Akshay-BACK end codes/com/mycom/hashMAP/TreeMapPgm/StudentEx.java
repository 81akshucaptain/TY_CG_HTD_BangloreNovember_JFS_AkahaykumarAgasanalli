package com.mycom.hashMAP.TreeMapPgm;

public class StudentEx implements Comparable {
	int age;
	String name;
	public StudentEx(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		StudentEx s=(StudentEx)o;
		if(this.age>s.age) {
			return 1;
		}else if(this.age<s.age) {
			return -1;
		}else
			return 0;
		/*return this.name.compareTo(s.name);*/
	}
	@Override
	public String toString() {
		return "StudentEx [age=" + age + ", name=" + name + "]";
	}

}
