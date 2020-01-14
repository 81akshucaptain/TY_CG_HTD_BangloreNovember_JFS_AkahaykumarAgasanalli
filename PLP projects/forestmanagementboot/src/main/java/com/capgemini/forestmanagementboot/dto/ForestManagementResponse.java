package com.capgemini.forestmanagementboot.dto;

import java.util.List;

public class ForestManagementResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<ProductBean> product;
	private List<CustomerBean> customer;
	private List<ContractorBean> contract;
	private List<LandsBean> land;

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

	public List<ProductBean> getProduct() {
		return product;
	}

	public void setProduct(List<ProductBean> product) {
		this.product = product;
	}

	public List<CustomerBean> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerBean> customer) {
		this.customer = customer;
	}

	public List<ContractorBean> getContract() {
		return contract;
	}

	public void setContract(List<ContractorBean> contract) {
		this.contract = contract;
	}

	public List<LandsBean> getLand() {
		return land;
	}

	public void setLand(List<LandsBean> land) {
		this.land = land;
	}

}
