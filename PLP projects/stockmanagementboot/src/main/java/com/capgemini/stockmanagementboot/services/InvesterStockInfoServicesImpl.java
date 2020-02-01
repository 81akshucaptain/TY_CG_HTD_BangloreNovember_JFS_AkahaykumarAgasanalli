package com.capgemini.stockmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dao.InvestersStockInfoDAO;
import com.capgemini.stockmanagementboot.dto.InvesterStocksInfoBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;
import com.capgemini.stockmanagementboot.exceptions.VallidationExceptionFMS;
import com.capgemini.stockmanagementboot.util.Validations;

@Service
public class InvesterStockInfoServicesImpl implements InvesterStockInfoServices{

	@Autowired
	InvestersStockInfoDAO investerStockInfoDao;
	
	@Override
	public List<InvesterStocksInfoBean> getAllInvesterStockInfo() {
		// TODO Auto-generated method stub
		return investerStockInfoDao.getAllInvesterStockInfo();
	}

	@Override
	public boolean updateInvesterStocksInfo(int transactionId, InvesterStocksInfoBean investerStockInfo) {
		try {
			if (Validations.numberValidation(transactionId)
					&& Validations.alphabetsValidation(investerStockInfo.getCompanyName())
					&& Validations.numberValidation(investerStockInfo.getCompanyID())
					&& Validations.numberValidation(investerStockInfo.getCurrentPrice())
					&& Validations.numberValidation(investerStockInfo.getPurchasedPrice())
					&& Validations.numberValidation(investerStockInfo.getStocksVolume())
					&& Validations.numberValidation(investerStockInfo.getTotalPrice())) {
				return investerStockInfoDao.updateInvesterStocksInfo(transactionId, investerStockInfo);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	@Override
	public boolean deleteInvesterStockInfo(int transactionId) {
		try {
			if (Validations.numberValidation(transactionId)) {
				return investerStockInfoDao.deleteInvesterStockInfo(transactionId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean addInvesterStockInfo(InvesterStocksInfoBean investerStockInfo) {
		try {
			if (Validations.alphabetsValidation(investerStockInfo.getCompanyName())
					&& Validations.numberValidation(investerStockInfo.getCompanyID())
					&& Validations.numberValidation(investerStockInfo.getCurrentPrice())
					&& Validations.numberValidation(investerStockInfo.getPurchasedPrice())
					&& Validations.numberValidation(investerStockInfo.getStocksVolume())
					&& Validations.numberValidation(investerStockInfo.getTotalPrice())) {
				return investerStockInfoDao.addInvesterStockInfo(investerStockInfo);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	@Override
	public InvesterStocksInfoBean searchInvesterStockInfo(int transactionId) {
		try {
			if (Validations.numberValidation(transactionId)) {
				return investerStockInfoDao.searchInvesterStockInfo(transactionId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public InvesterStocksInfoBean searchInvesterInfoByCompanyName(String investerStockInfoName) {
		try {
			if (Validations.emailValidation(investerStockInfoName)) {
				return investerStockInfoDao.searchInvesterInfoByCompanyName(investerStockInfoName);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
