package com.capgemini.forestmnagementdb.bean;

public class ProductBean {

	private int productId;
	private String name;
	private String productClass;
	private int quantity;
	private int cost;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "            ::::PRODUCT DETAILS :::: " + "\n PRODUCT-ID  = " + productId + "\n NAME        = " + name
				+ "\n QUANTITY    = " + quantity + "\n PRODUCTCLASS= " + productClass + "\n COST        = " + cost
				+ "\n=========================================================\n";

	}

}
