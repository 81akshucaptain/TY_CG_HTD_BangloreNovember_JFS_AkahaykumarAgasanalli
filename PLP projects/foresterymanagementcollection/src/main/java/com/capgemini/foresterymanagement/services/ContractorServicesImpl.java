package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.dao.ContractorDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class ContractorServicesImpl implements ContractorServices {
	
	ContractorDAO contractDao = ForestFactory.instanceOfContractorDAOImpl();

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
