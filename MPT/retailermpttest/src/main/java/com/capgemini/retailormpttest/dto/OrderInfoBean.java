package com.capgemini.retailormpttest.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class OrderInfoBean {
	@Id
	@Column
	@GeneratedValue
	int oid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "uid")
	private UserInfoBean userBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "pid")
	private ProductInfoBean productBean;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public UserInfoBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserInfoBean userBean) {
		this.userBean = userBean;
	}

	public ProductInfoBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductInfoBean productBean) {
		this.productBean = productBean;
	}
	
	
}
