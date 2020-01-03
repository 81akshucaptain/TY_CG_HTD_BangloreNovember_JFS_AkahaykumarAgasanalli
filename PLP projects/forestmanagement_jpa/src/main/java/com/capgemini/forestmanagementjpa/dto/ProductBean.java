package com.capgemini.forestmanagementjpa.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jpaProduct")
public class ProductBean {
	@Id
	@Column
	private int PID;
	@Column
	private String name;
	@Column
	private String productClass;
	@Column
	private int quantity;
	@Column
	private int cost;
	@Column
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
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public int getQantity() {
		return quantity;
	}
	public void setQantity(int quantity) {
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
		return  "\nPRODUCT-ID     =" + PID + 
				"\nPRODUCT NAME   =" + name + 
				"\nPRODUCT CLASS  =" + productClass + 
				"\nPRODUCT-QANTITY=" + quantity+
				"\nPRODUCT-COST =" + cost+
				"\n===============================================================";
	}
}
