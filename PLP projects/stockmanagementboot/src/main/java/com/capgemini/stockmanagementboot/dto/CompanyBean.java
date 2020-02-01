package com.capgemini.stockmanagementboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class CompanyBean {
	@Id
	@GeneratedValue
	@Column
	private int companyID;
	@Column
	private String companyName;
	@Column
	private String companyDirector;
	@Column
	private String companyChairman;
	@Column
	private String companyEmail;
	@Column
	private String companyPhone;
	@Column
	private String companyCity;
	@Column
	private long maxInvest;
	@Column
	private int maxStocksPurchase;

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDirector() {
		return companyDirector;
	}

	public void setCompanyDirector(String companyDirector) {
		this.companyDirector = companyDirector;
	}

	public String getCompanyChairman() {
		return companyChairman;
	}

	public void setCompanyChairman(String companyChairman) {
		this.companyChairman = companyChairman;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public long getMaxInvest() {
		return maxInvest;
	}

	public void setMaxInvest(long maxInvest) {
		this.maxInvest = maxInvest;
	}

	public int getMaxStocksPurchase() {
		return maxStocksPurchase;
	}

	public void setMaxStocksPurchase(int maxStocksPurchase) {
		this.maxStocksPurchase = maxStocksPurchase;
	}
}
