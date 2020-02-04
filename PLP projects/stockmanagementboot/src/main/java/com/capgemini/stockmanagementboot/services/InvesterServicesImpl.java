package com.capgemini.stockmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dao.InvesterDAO;
import com.capgemini.stockmanagementboot.dto.InvesterBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;
import com.capgemini.stockmanagementboot.exceptions.VallidationExceptionFMS;
import com.capgemini.stockmanagementboot.util.Validations;

@Service
public class InvesterServicesImpl implements InvesterServices {
	@Autowired
	InvesterDAO investerDao;

	@Override
	public List<InvesterBean> getAllInvesters() {
		// TODO Auto-generated method stub
		return investerDao.getAllInvesters();
	}

	@Override
	public boolean updateInvesters(int investerId, InvesterBean invester) {
		try {
			if (Validations.numberValidation(investerId)
					&& Validations.alphabetsValidation(invester.getInvesterCity())
					&& Validations.alphabetsValidation(invester.getInvesterName())
					&& Validations.emailValidation(invester.getInvesterEmail())
					&& Validations.phoneNumberValidation(invester.getInvesterPhone())
					&& Validations.postalValidation(invester.getInvesterPostal())) {
				return investerDao.updateInvesters(investerId, invester);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteInvester(int investerId) {
		try {
			if (Validations.numberValidation(investerId)) {
				return investerDao.deleteInvester(investerId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}


	@Override
	public boolean addInvester(InvesterBean invester) {
		try {
			if ( Validations.alphabetsValidation(invester.getInvesterCity())
					&& Validations.alphabetsValidation(invester.getInvesterName())
					&& Validations.emailValidation(invester.getInvesterEmail())
					&& Validations.phoneNumberValidation(invester.getInvesterPhone())
					&& Validations.postalValidation(invester.getInvesterPostal())) {
				return investerDao.addInvester(invester);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	@Override
	public InvesterBean searchInvester(int investerId) {
		try {
			if (Validations.numberValidation(investerId)) {
				return investerDao.searchInvester(investerId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public InvesterBean searchInvesterByEmail(String investerEmail) {
		try {
			if (Validations.emailValidation(investerEmail)) {
				return investerDao.searchInvesterByEmail(investerEmail);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
