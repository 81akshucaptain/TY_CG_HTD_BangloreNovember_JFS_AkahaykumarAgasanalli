package com.capgemini.forestmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementboot.dao.ContractorDAO;
import com.capgemini.forestmanagementboot.dto.ContractorBean;
import com.capgemini.forestmanagementboot.exceptionss.VallidationExceptionFMS;
import com.capgemini.forestmanagementboot.util.Validations;

@Service
public class ContractorServicesImpl implements ContractorServices {

	@Autowired
	ContractorDAO contractDao;

	@Override
	public List<ContractorBean> getAllContarctor() {
		return contractDao.getAllContarctor();
	}

	@Override
	public boolean updateContarctor(int cid, ContractorBean contarctorToUpdate) {
		try {
			if (Validations.numberValidation(cid) 
					&& Validations.numberValidation(contarctorToUpdate.getContractId())
					&& Validations.numberValidation(contarctorToUpdate.getCustomerId())
					&& Validations.numberValidation(contarctorToUpdate.getProductId())
					&& Validations.dateValidation(contarctorToUpdate.getDeliveryDate())
					&& Validations.haulierIdVallidation(contarctorToUpdate.getHaulierId())) {
				return contractDao.updateContarctor(cid, contarctorToUpdate);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean deletecontarctor(int cid) {
		try {
			if (Validations.numberValidation(cid)) {
				return contractDao.deletecontarctor(cid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {
		try {
			if ( Validations.numberValidation(contractor.getContractId())
					&& Validations.numberValidation(contractor.getCustomerId())
					&& Validations.numberValidation(contractor.getProductId())
					&& Validations.dateValidation(contractor.getDeliveryDate())
					&& Validations.haulierIdVallidation(contractor.getHaulierId())
					&& Validations.numberValidation(contractor.getQunatity())) {
				return contractDao.addContarctor(contractor);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public ContractorBean searchContarctor(int cid) {
		try {
			if (Validations.numberValidation(cid)) {
				return contractDao.searchContarctor(cid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
