package com.capgemini.forestmanagementjpa.dto;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jpaProduct")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue
	private int productId;
	@Column
	private String name;
	@Column
	private String productClass;
	@Column
	private int quantity;
	@Column
	private int cost;

	@Column
	@Override
	public String toString() {
		return "\nPRODUCT-ID     =" + productId + "\nPRODUCT NAME   =" + name + "\nPRODUCT CLASS  =" + productClass
				+ "\nPRODUCT-QANTITY=" + quantity + "\nPRODUCT-COST =" + cost
				+ "\n===============================================================";
	}

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
}
