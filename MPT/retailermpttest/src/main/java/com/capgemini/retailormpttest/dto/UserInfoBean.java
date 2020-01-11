package com.capgemini.retailormpttest.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user_info")
public class UserInfoBean {
	
	@Id
	@Column
	@GeneratedValue
	int uid;
	@Column
	String uname;
	@Column(unique = true,nullable = false)
	String email;
	@Column
	String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userBean" )
	private List<ProductInfoBean> productBean;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<ProductInfoBean> getProductBean() {
		return productBean;
	}
	public void setProductBean(List<ProductInfoBean> productBean) {
		this.productBean = productBean;
	}
}
