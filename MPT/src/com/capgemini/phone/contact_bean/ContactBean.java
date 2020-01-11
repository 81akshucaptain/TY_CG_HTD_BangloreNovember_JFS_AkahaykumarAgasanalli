package com.capgemini.phone.contact_bean;

import java.io.Serializable;

public class ContactBean implements Serializable{
String name;
String number;
String group;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getGroup() {
	return group;
}
public void setGroup(String group) {
	this.group = group;
}

}
