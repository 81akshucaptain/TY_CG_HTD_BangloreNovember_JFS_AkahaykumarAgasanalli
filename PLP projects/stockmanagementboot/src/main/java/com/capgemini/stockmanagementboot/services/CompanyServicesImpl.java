package com.capgemini.stockmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dao.CompanyDAO;
import com.capgemini.stockmanagementboot.dto.CompanyBean;
import com.capgemini.stockmanagementboot.exceptions.VallidationExceptionFMS;
import com.capgemini.stockmanagementboot.util.Validations;

@Service
public class CompanyServicesImpl implements CompanyServices {

	@Autowired
	CompanyDAO companyDao;

	@Override
	public List<CompanyBean> getAllCompany() {
		return companyDao.getAllCompany();
	}

	@Override
	public boolean updateCompany(int companyId, CompanyBean company) {
		try {
			if (Validations.numberValidation(companyId)
					&& Validations.alphabetsValidation(company.getCompanyChairman())
					&& Validations.alphabetsValidation(company.getCompanyDirector())
					&& Validations.alphabetsValidation(company.getCompanyName())
					&& Validations.alphabetsValidation(company.getCompanyCity())
					&& Validations.emailValidation(company.getCompanyEmail())
					&& Validations.phoneNumberValidation(company.getCompanyPhone())
					&& Validations.numberValidation(company.getMaxStocksPurchase())
					&& Validations.numberValidationForLong(company.getMaxInvest())) {
				return companyDao.updateCompany(companyId, company);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteCompany(int companyId) {
		try {
			if (Validations.numberValidation(companyId)) {
				return companyDao.deleteCompany(companyId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}


	@Override
	public boolean addCompany(CompanyBean company) {
		try {
			if ( Validations.alphabetsValidation(company.getCompanyChairman())
					&& Validations.alphabetsValidation(company.getCompanyDirector())
					&& Validations.alphabetsValidation(company.getCompanyName())
					&& Validations.alphabetsValidation(company.getCompanyCity())
					&& Validations.emailValidation(company.getCompanyEmail())
					&& Validations.phoneNumberValidation(company.getCompanyPhone())
					&& Validations.numberValidation(company.getMaxStocksPurchase())
					&& Validations.numberValidationForLong(company.getMaxInvest())) {
				return companyDao.addCompany(company);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	

	@Override
	public CompanyBean searchCompany(int companyId) {
		try {
			if (Validations.numberValidation(companyId)) {
				return companyDao.searchCompany(companyId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}


	@Override
	public CompanyBean searchCompanyByMail(String email) {
		try {
			if (Validations.emailValidation(email)) {
				return companyDao.searchCompanyByMail(email);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
