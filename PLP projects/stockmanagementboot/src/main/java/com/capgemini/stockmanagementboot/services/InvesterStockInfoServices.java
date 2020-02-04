package com.capgemini.stockmanagementboot.services;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.InvesterStocksInfoBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;

public interface InvesterStockInfoServices {
	public List<InvesterStocksInfoBean> getAllInvesterStockInfo();
	
	public List<InvesterStocksInfoBean> searchInvesterStockInfoByInvesterID(int investerID);

	public boolean updateInvesterStocksInfo(int transactionId, InvesterStocksInfoBean investerStockInfoToUpdate);

	public boolean deleteInvesterStockInfo(InvesterStocksInfoBean investerStocksInfoBean);

	public boolean addInvesterStockInfo(InvesterStocksInfoBean investerStockInfo);

	public InvesterStocksInfoBean searchInvesterStockInfo(int transactionId);

	public InvesterStocksInfoBean searchInvesterInfoByCompanyName(String companyName);
}
