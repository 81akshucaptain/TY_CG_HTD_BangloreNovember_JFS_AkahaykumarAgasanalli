package com.capgemini.retailormpttest.dto;

import java.util.List;

public class RetailerResponse {
	private int statusCode;
	private String message;
	private String discription;
	private List<UserInfoBean> userBeans;
	private List<ProductInfoBean> productBeans;
	private List<OrderInfoBean> ordersBeans;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<UserInfoBean> getUserBeans() {
		return userBeans;
	}
	public void setUserBeans(List<UserInfoBean> userBeans) {
		this.userBeans = userBeans;
	}
	public List<ProductInfoBean> getProductBeans() {
		return productBeans;
	}
	public void setProductBeans(List<ProductInfoBean> productBeans) {
		this.productBeans = productBeans;
	}
	public List<OrderInfoBean> getOrdersBeans() {
		return ordersBeans;
	}
	public void setOrdersBeans(List<OrderInfoBean> ordersBeans) {
		this.ordersBeans = ordersBeans;
	}
	
	
}
