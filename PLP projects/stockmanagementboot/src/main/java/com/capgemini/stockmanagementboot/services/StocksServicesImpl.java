package com.capgemini.stockmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dao.StocksDAO;
import com.capgemini.stockmanagementboot.dto.StocksBean;
import com.capgemini.stockmanagementboot.exceptions.VallidationExceptionFMS;
import com.capgemini.stockmanagementboot.util.Validations;

@Service
public class StocksServicesImpl implements StocksServices {

	@Autowired
	StocksDAO stocksDao;
	
	@Override
	public List<StocksBean> getAllStocks() {
		// TODO Auto-generated method stub
		return stocksDao.getAllStocks();
	}

	@Override
	public boolean updateStocks(int stockId, StocksBean stocks) {
		try {
			if (Validations.numberValidation(stockId)
					&& Validations.alphabetsValidation(stocks.getCompanyName())
					&& Validations.numberValidation(stocks.getAvailableStocks())
					&& Validations.FloatingNumberValidation(stocks.getChangePercentage())
					&& Validations.numberValidation(stocks.getCurrentPrice())
					&& Validations.numberValidation(stocks.getLastPrice())
					&& Validations.numberValidation(stocks.getCompanyID())
					&& Validations.numberValidation(stocks.getTotalStocks())) {
				return stocksDao.updateStocks(stockId, stocks);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	@Override
	public boolean deleteStocks(int stockId) {
		try {
			if (Validations.numberValidation(stockId)) {
				return stocksDao.deleteStocks(stockId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}



	@Override
	public boolean addStocks(StocksBean stocks) {
		try {
			if (Validations.alphabetsValidation(stocks.getCompanyName())
					&& Validations.numberValidation(stocks.getAvailableStocks())
					&& Validations.FloatingNumberValidation(stocks.getChangePercentage())
					&& Validations.numberValidation(stocks.getCurrentPrice())
					&& Validations.numberValidation(stocks.getLastPrice())
					&& Validations.numberValidation(stocks.getCompanyID())
					&& Validations.numberValidation(stocks.getTotalStocks())) {
				return stocksDao.addStocks(stocks);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	@Override
	public StocksBean searchStocks(int managerId) {
		try {
			if (Validations.numberValidation(managerId)) {
				return stocksDao.searchStocks(managerId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public StocksBean searchStocksByCompanyID(int companyID) {
		try {
			if (Validations.numberValidation(companyID)) {
				return stocksDao.searchStocksByCompanyID(companyID);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}


}
