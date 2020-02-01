package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import com.capgemini.stockmanagementboot.dto.InvesterStocksInfoBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;

public interface InvestersStockInfoDAO {
	public List<InvesterStocksInfoBean> getAllInvesterStockInfo();

	public boolean updateInvesterStocksInfo(int transactionId, InvesterStocksInfoBean investerStockInfoToUpdate);

	public boolean deleteInvesterStockInfo(int transactionId);

	public boolean addInvesterStockInfo(InvesterStocksInfoBean investerStockInfo);

	public InvesterStocksInfoBean searchInvesterStockInfo(int transactionId);

	public InvesterStocksInfoBean searchInvesterInfoByCompanyName(String companyName);

}
