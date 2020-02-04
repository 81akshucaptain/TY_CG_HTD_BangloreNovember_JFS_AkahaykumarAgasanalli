package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.InvesterStocksInfoBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;

public interface InvestersStockInfoDAO {
	public List<InvesterStocksInfoBean> getAllInvesterStockInfo();

	public List<InvesterStocksInfoBean> searchInvesterStockInfoByInvesterID(int investerID);

	public boolean updateInvesterStocksInfo(int transactionId, InvesterStocksInfoBean investerStockInfoToUpdate);

	public boolean deleteInvesterStockInfo(InvesterStocksInfoBean investerStocksInfoBean);

	public boolean addInvesterStockInfo(InvesterStocksInfoBean investerStockInfo);

	public InvesterStocksInfoBean searchInvesterStockInfo(int transactionId);

	public InvesterStocksInfoBean searchInvesterInfoByCompanyName(String companyName);

	public InvesterStocksInfoBean searchInvesterStockInfoByStockID(int stockID);
	
	public void updateStockCountBasedOnPurchase(int stockID, int stockVolume, String status) ;
	
	public StocksBean searchStocks(int stockId) ;
}
