package com.captain.Fm.bean;

public class ContractorBean {
int contractorId;
@Override
public String toString() {
	return "Contractors are \ncontractorId=" + contractorId + ",\n customerId=" + customerId + ",\n productId=" + productId
			+ ",\n haulierId=" + haulierId + ",\n deliveryDate=" + deliveryDate + ", \n deliveryDay=" + deliveryDay
			+ ",\n qunatity=" + qunatity + "\n===============================================================\n";
}
int customerId;
int productId;
int haulierId;
String deliveryDate;
String deliveryDay;
int qunatity;
public int getContractorId() {
	return contractorId;
}
public void setContractorId(int contractorId) {
	this.contractorId = contractorId;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getHaulierId() {
	return haulierId;
}
public void setHaulierId(int haulierId) {
	this.haulierId = haulierId;
}
public String getDeliveryDate() {
	return deliveryDate;
}
public void setDeliveryDate(String deliveryDate) {
	this.deliveryDate = deliveryDate;
}
public String getDeliveryDay() {
	return deliveryDay;
}
public void setDeliveryDay(String deliveryDay) {
	this.deliveryDay = deliveryDay;
}
public int getQunatity() {
	return qunatity;
}
public void setQunatity(int qunatity) {
	this.qunatity = qunatity;
}
}
