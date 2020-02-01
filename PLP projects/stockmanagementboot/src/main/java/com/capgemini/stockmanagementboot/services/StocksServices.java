package com.capgemini.stockmanagementboot.services;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.ManagerBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;

public interface StocksServices {
	
	public List<StocksBean> getAllStocks();

	public boolean updateStocks(int stockId, StocksBean stocksToUpdate);

	public boolean deleteStocks(int stockId);

	public boolean addStocks(StocksBean stocks);

	public StocksBean searchStocks(int managerId);

	public StocksBean searchStocksByCompanyID(int companyID);
}

