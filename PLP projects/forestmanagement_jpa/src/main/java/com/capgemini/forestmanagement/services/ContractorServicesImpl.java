package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dao.ContractorDAO;
import com.capgemini.forestmanagementjpa.dto.ContractorBean;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class ContractorServicesImpl implements ContractorServices {
	
	ContractorDAO contractDao = ForestFactoryFmJpa.createInstanceOfContractorDAOImpl();

	@Override
	public void getAllContarctor() {
		contractDao.getAllContarctor();
	}

	@Override
	public boolean updateContarctor(int cid, ContractorBean contarctorToUpdate) {
		return contractDao.updateContarctor(cid, contarctorToUpdate);
	}

	@Override
	public boolean deletecontarctor(int cid) {
		return contractDao.deletecontarctor(cid);
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {
		return contractDao.addContarctor(contractor);
	}

	@Override
	public ContractorBean searchContarctor(int cid) {
		return contractDao.searchContarctor(cid);
	}

}
