package com.capgemini.stockmanagementboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invester")
public class InvesterBean {

	@Id
	@GeneratedValue
	@Column
	private int investerID;
	@Column
	private String investerName;
	@Column
	private String investerEmail;
	@Column
	private String investerPhone;
	@Column
	private String investerCity;
	@Column
	private int investerPostal;

	public int getInvesterID() {
		return investerID;
	}

	public void setInvesterID(int investerID) {
		this.investerID = investerID;
	}

	public String getInvesterName() {
		return investerName;
	}

	public void setInvesterName(String investerName) {
		this.investerName = investerName;
	}

	public String getInvesterEmail() {
		return investerEmail;
	}

	public void setInvesterEmail(String investerEmail) {
		this.investerEmail = investerEmail;
	}

	public String getInvesterPhone() {
		return investerPhone;
	}

	public void setInvesterPhone(String investerPhone) {
		this.investerPhone = investerPhone;
	}

	public String getInvesterCity() {
		return investerCity;
	}

	public void setInvesterCity(String investerCity) {
		this.investerCity = investerCity;
	}

	public int getInvesterPostal() {
		return investerPostal;
	}

	public void setInvesterPostal(int investerPostal) {
		this.investerPostal = investerPostal;
	}

}
