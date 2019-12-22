package com.captain.Fm.bean;

public class ContractorBean {
	
	int contractId;
	int customerId;
	int productId;
	String haulierId;
	String deliveryDate;
	String deliveryDay;
	int qunatity;

	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
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
	public String getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(String haulierId) {
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
	@Override
	public String toString() {
		return ":::::::::CONTRACT DETAILS::::::: \n"+" \n CUSTOMERID=" + customerId + "\n PRODUCTID=" + productId
				+ "\n HAULIERID=" + haulierId + "\n DELIVERY-DATE=" + deliveryDate + " \n DELIVERYDAY=" + deliveryDay
				+ "\n QUNATITY=" + qunatity + "\n=========================================================\n";
	}
}
