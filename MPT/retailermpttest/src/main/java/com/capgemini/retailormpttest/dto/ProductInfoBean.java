package com.capgemini.retailormpttest.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product_info")
public class ProductInfoBean {
	@Id
	@Column
	// Automatically generates the unique id
	@GeneratedValue
	int pid;
	@Column(unique = true, nullable = false)
	String pname;
	@Column
	int quantity;
	@Column
	String details;
	@Column
	int cost;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "uid")
	private List<UserInfoBean> userBean;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "oder_id", referencedColumnName = "oid")
	private List<OrderInfoBean> orderBean;
	

	public List<OrderInfoBean> getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(List<OrderInfoBean> orderBean) {
		this.orderBean = orderBean;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<UserInfoBean> getUserBean() {
		return userBean;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setUserBean(List<UserInfoBean> userBean) {
		this.userBean = userBean;
	}

	
}
