package com.captain.Fm.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	static int cid;
	String name;
	String town;
	int postal;
	String email;
	long phone;

	public  int getCid() {
		return cid;
	}
	public  void setCid(int cid) {
		CustomerBean.cid = cid;
	}
	public  String getName() {
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

		return  " NAME=" + name + "\n TOWN=" + town + "\n POSTAL=" + postal + "\n EMAIL=" + email
				+ "\n PHONE=" + phone + "\n=========================================================\n";
	}

}
