package com.capgemini.stockmanagementboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class StocksBean {
	@Id
	@GeneratedValue
	@Column
	private int stockID;
	@Column
	private String companyName;
	@Column
	private int companyID;
	@Column
	private int currentPrice;
	@Column
	private int lastPrice;
	@Column
	private double changePercentage;
	@Column
	private int availableStocks;
	@Column
	private int totalStocks;

	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(int lastPrice) {
		this.lastPrice = lastPrice;
	}

	public double getChangePercentage() {
		return changePercentage;
	}

	public void setChangePercentage(double changePercentage) {
		this.changePercentage = changePercentage;
	}

	public int getAvailableStocks() {
		return availableStocks;
	}

	public void setAvailableStocks(int availableStocks) {
		this.availableStocks = availableStocks;
	}

	public int getTotalStocks() {
		return totalStocks;
	}

	public void setTotalStocks(int totalStocks) {
		this.totalStocks = totalStocks;
	}

}
