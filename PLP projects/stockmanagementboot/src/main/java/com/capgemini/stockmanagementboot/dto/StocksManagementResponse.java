package com.capgemini.stockmanagementboot.dto;

import java.util.List;



public class StocksManagementResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<CompanyBean> companies;
	private List<ManagerBean> managers;
	private List<StocksBean> stocks;
	private List<InvesterBean> investers;
	private List<InvesterStocksInfoBean> investerInfo;
	private List<UsersAuthenticationBean> users;

	public List<UsersAuthenticationBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersAuthenticationBean> users) {
		this.users = users;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CompanyBean> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyBean> companies) {
		this.companies = companies;
	}

	public List<ManagerBean> getManagers() {
		return managers;
	}

	public void setManagers(List<ManagerBean> managers) {
		this.managers = managers;
	}

	public List<StocksBean> getStocks() {
		return stocks;
	}

	public void setStocks(List<StocksBean> stocks) {
		this.stocks = stocks;
	}

	public List<InvesterBean> getInvesters() {
		return investers;
	}

	public void setInvesters(List<InvesterBean> investers) {
		this.investers = investers;
	}

	public List<InvesterStocksInfoBean> getInvesterInfo() {
		return investerInfo;
	}

	public void setInvesterInfo(List<InvesterStocksInfoBean> investerInfo) {
		this.investerInfo = investerInfo;
	}

}
