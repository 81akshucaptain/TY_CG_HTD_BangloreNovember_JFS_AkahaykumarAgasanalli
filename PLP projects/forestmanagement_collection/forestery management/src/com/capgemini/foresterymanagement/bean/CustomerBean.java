package com.capgemini.foresterymanagement.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	static int customerId;
	String name;
	String town;
	int postal;
	String email;
	long phone;
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public static int getCustomerId() {
		return customerId;
	}

	public static void setCustomerId(int customerId) {
		CustomerBean.customerId = customerId;
	}

	@Override
	public String toString() {

		return "            ::::CUSTOMER DETAILS::::" + "\n CUSTOMER-ID = " + customerId + "\n NAME        = " + name
				+ "\n TOWN        = " + town + "\n POSTAL      = " + postal + "\n EMAIL       = " + email
				+ "\n PHONE       = " + phone + "\n=========================================================\n";
	}

}
