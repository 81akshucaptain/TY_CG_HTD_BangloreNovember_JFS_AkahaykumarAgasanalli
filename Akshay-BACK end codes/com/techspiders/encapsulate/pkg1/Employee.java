package com.techspiders.encapsulate.pkg1;
 public class Employee {
	int eage=21;
	public String ename;
	public static int x=12;
	 public  Employee (String ename){
		this.ename=ename;
	}
	  //protected so this can  be accessed outsidE PKG ONLY BY EXTENDING THE CLASS
	protected void display() {
		 System.out.println("display method is here");
	 }
}
