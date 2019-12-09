package com.capatin.fmdb.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
int cid;
String name;
String town;
int postal;
String email;
long phone;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public int getPostal() {
	return postal;
}
public void setPostal(int postal) {
	this.postal = postal;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
@Override
public String toString() {

return "Customer details are:\n"
			+ ", name=" + name + "\n, town=" + town + "\n, postal=" + postal + "\n, email=" + email
			+ "\n, phone=" + phone + "\n=================================================================\n";
}

}
