package com.capgemini.stockmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dao.ManagerDAO;
import com.capgemini.stockmanagementboot.dto.CompanyBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;
import com.capgemini.stockmanagementboot.exceptions.VallidationExceptionFMS;
import com.capgemini.stockmanagementboot.util.Validations;

@Service
public class ManagerServiceImpl implements ManagerServices {
	@Autowired
	ManagerDAO managerDao;

	@Override
	public List<ManagerBean> getAllManager() {
		// TODO Auto-generated method stub
		return managerDao.getAllManager();
	}

	@Override
	public boolean updateManager(int managerId, ManagerBean managerToAdd) {
		try {
			if (Validations.numberValidation(managerId)
					&& Validations.alphabetsValidation(managerToAdd.getManagerCity())
					&& Validations.alphabetsValidation(managerToAdd.getManagerCompany())
					&& Validations.alphabetsValidation(managerToAdd.getManagerName())
					&& Validations.emailValidation(managerToAdd.getManagerEmail())
					&& Validations.phoneNumberValidation(managerToAdd.getManagerPhone())
					&& Validations.postalValidation(managerToAdd.getManagerPostal())) {
				return managerDao.updateManager(managerId, managerToAdd);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteManager(int managerId) {
		try {
			if (Validations.numberValidation(managerId)) {
				return managerDao.deleteManager(managerId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean addManager(ManagerBean managerToAdd) {
		try {
			if (Validations.alphabetsValidation(managerToAdd.getManagerCity())
					&& Validations.alphabetsValidation(managerToAdd.getManagerCompany())
					&& Validations.alphabetsValidation(managerToAdd.getManagerName())
					&& Validations.emailValidation(managerToAdd.getManagerEmail())
					&& Validations.phoneNumberValidation(managerToAdd.getManagerPhone())
					&& Validations.postalValidation(managerToAdd.getManagerPostal())) {
				return managerDao.addManager(managerToAdd);
			} else {
				return false;
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public ManagerBean searchManager(int managerId) {
		try {
			if (Validations.numberValidation(managerId)) {
				return managerDao.searchManager(managerId);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public ManagerBean searchManagerByMail(String email) {
		try {
			if (Validations.emailValidation(email)) {
				return managerDao.searchManagerByMail(email);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
