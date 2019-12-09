package com.capgemini.jdbc.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
private String usn;
private int age;
private String college;
private String adress;
private String name;
private String unmae;
private String psw;
public String getUsn() {
	return usn;
}
public void setUsn(String usn) {
	this.usn = usn;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getUname() {
	return unmae;
}
@Override
public String toString() {
	return "UserBean [usn=" + usn + ", age=" + age + ", college=" + college + ", adress=" + adress + ", name=" + name
			+ ", unmae=" + unmae + ", psw=" + psw + "]";
}
public void setUname(String unmae) {
	this.unmae = unmae;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}


}
