package com.capgemini.mywebapp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_servlet")
public class EmployeeBean {
	
	@Id
	@Column
int empid;
	@Column
String name;
	@Column
String salary;
	@Column
int age;
	@Column
String password;
	@Column
String designation;

public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
@Override
public String toString() {
	return "EmployeeBean [empid=" + empid + ", name=" + name + ", salary=" + salary + ", age=" + age + ", password="
			+ password + ", esignation=" + designation + ", getEmpid()=" + getEmpid() + ", getName()=" + getName()
			+ ", getSalary()=" + getSalary() + ", getAge()=" + getAge() + ", getPassword()=" + getPassword()
			+ ", getEsignation()=" + getDesignation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
}
