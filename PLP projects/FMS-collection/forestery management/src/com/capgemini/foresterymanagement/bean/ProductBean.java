package com.capgemini.foresterymanagement.bean;

public class ProductBean {
	int pid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	String name;
	int quantity;
	String productClass;
	int cost;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String pclass) {
		this.productClass = pclass;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "PRODUCT DETAILS ARE : \n NAME=" + name + "\n QUANTITY=" + quantity + "\n PRODUCTCLASS=" + productClass + "\n COST=" + cost
				+ "\n=========================================================\n";
	}


}
