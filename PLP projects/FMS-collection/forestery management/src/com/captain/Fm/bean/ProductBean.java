package com.captain.Fm.bean;

public class ProductBean {
	
String name;
int quantity;
char productClass;
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
public char getProductClass() {
	return productClass;
}
public void setProductClass(char productClass) {
	this.productClass = productClass;
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
			+ "\n======================================================================\n";
}


}