package com.techspiders.encapsulate.pkg2;

import com.techspiders.encapsulate.pkg1.Employee;

public class ProtectedExample extends Employee{

	ProtectedExample(String ename) {
		super(ename);
		// TODO Auto-generated constructor stub
	}
	 
	public static void main(String[] args) {
		ProtectedExample p1=new ProtectedExample("akshay");
		p1.display();
	}
	

}
