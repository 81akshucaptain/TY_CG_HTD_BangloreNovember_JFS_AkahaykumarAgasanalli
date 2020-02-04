package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.StocksBean;

public interface StocksDAO {

	public List<StocksBean> getAllStocks();

	public boolean updateStocks(int stockId, StocksBean stocksToUpdate);

	public boolean deleteStocks(int stockId);

	public boolean addStocks(StocksBean stocks);

	public StocksBean searchStocks(int managerId);

	public StocksBean searchStocksByCompanyID(int companyID);
		
	public boolean updateInvesterStocksInfoBasedOnCurrrentPrice(int stockID, int currentPrice) ;

	
}
