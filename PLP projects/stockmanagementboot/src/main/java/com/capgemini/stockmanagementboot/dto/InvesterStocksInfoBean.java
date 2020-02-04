package com.capgemini.stockmanagementboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="investerStockInfo")
public class InvesterStocksInfoBean {

	@Id
	@GeneratedValue
	@Column
	private int transactionID;
	@Column
	private int investerID;
	@Column
	private int stockID;
	@Column
	private String companyName;
	@Column
	private int companyID;
	@Column
	private int stocksVolume;
	@Column
	private int purchasedPrice;
	@Column
	private int totalPrice;
	@Column
	private int currentPrice;
	@Column
	private int profitAmount;
	

	public int getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(int profitAmount) {
		this.profitAmount = profitAmount;
	}
	public int getInvesterID() {
		return investerID;
	}
	public void setInvesterID(int investerID) {
		this.investerID = investerID;
	}
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public int getStocksVolume() {
		return stocksVolume;
	}

	public void setStocksVolume(int stocksVolume) {
		this.stocksVolume = stocksVolume;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPurchasedPrice() {
		return purchasedPrice;
	}

	public void setPurchasedPrice(int purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
}
