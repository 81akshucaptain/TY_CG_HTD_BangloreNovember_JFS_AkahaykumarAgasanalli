package com.capgemini.forestmanagementjpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JpaContract")
public class ContractorBean {
	@Id
	@Column
	int contractId;
	@Column
	int customerId;
	@Column
	int productId;
	@Column
	String haulierId;
	@Column
	String deliveryDate;
	@Column
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
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	@Override
	public String toString() {
		return ":::::::::CONTRACT DETAILS::::::: \n"+" \n CUSTOMERID=" + customerId + "\n PRODUCTID=" + productId
				+ "\n HAULIERID=" + haulierId + "\n DELIVERY-DATE=" + deliveryDate + "\n QUNATITY=" + qunatity + 
				"\n=========================================================\n";
	}
}