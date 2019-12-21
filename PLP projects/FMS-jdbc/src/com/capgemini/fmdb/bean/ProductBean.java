package com.capgemini.fmdb.bean;

public class ProductBean {
private int PID;
private String name;
private String ProductClass;
private int qantity;
private int cost;
public int getPID() {
	return PID;
}
public void setPID(int pID) {
	PID = pID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProductClass() {
	return ProductClass;
}
public void setProductClass(String productClass) {
	ProductClass = productClass;
}
public int getQantity() {
	return qantity;
}
public void setQantity(int qantity) {
	this.qantity = qantity;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}


}
