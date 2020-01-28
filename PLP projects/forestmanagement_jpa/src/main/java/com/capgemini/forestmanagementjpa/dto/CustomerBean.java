package com.capgemini.forestmanagementjpa.dto;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="jpaCustomer")
public class CustomerBean implements Serializable {
	@Id
	@Column
	@GeneratedValue
	private int customerId;
	@Column
	private String name;
	@Column
	private String town;
	@Column
	private int postal;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {

		return "            ::::CUSTOMER DETAILS::::"+ 
		        "\n CUSTOMER-ID = "+customerId+
			  "\n NAME        = " + name + 
			  "\n TOWN        = " + town + 
			  "\n POSTAL      = " + postal + 
			  "\n EMAIL       = " + email+
			  "\n PHONE       = " + phone + 
				"\n=========================================================\n";
	}
}
