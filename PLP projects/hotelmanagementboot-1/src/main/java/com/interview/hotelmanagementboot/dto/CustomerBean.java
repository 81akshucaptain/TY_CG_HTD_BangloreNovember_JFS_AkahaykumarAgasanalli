package com.interview.hotelmanagementboot.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerBean implements Serializable {
	// The serialized stream can be encrypted, authenticated and compressed,
	// supporting the needs of secure Java computing.
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private int customerID;
	@Column
	private String name;
	@Column
	private String place;
	@Column(unique = true, nullable = false)
	private String phone;
	@Column(unique = true, nullable = false)
	private String email;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerBean [customerID=" + customerID + ", name=" + name + ", place=" + place + ", phone=" + phone
				+ ", email=" + email + "]";
	}

}
