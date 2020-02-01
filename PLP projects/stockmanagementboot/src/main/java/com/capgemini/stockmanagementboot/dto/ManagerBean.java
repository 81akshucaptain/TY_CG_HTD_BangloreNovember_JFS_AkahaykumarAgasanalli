package com.capgemini.stockmanagementboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="manager")
public class ManagerBean {
	@Id
	@GeneratedValue
	@Column
	private int managerID;
	@Column
	private String managerName;
	@Column
	private String managerCompany;
	@Column
	private String managerPhone;
	@Column
	private String managerEmail;
	@Column
	private String managerCity;
	@Column
	private int managerPostal;

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerCompany() {
		return managerCompany;
	}

	public void setManagerCompany(String managerCompany) {
		this.managerCompany = managerCompany;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerCity() {
		return managerCity;
	}

	public void setManagerCity(String managerCity) {
		this.managerCity = managerCity;
	}

	public int getManagerPostal() {
		return managerPostal;
	}

	public void setManagerPostal(int managerPostal) {
		this.managerPostal = managerPostal;
	}
}
