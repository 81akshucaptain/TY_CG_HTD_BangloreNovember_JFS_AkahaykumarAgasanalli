package com.capgemini.forestmnagementdb.services;

import com.capgemini.forestmnagementdb.bean.ContractorBean;
import com.capgemini.forestmnagementdb.dao.ContractorDAO;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;

public class ContractorServicesImpl implements ContractorServices {
	
	ContractorDAO contractDao = ForestFactoryJdbc.createInstanceOfContractorDAOImpl();

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
