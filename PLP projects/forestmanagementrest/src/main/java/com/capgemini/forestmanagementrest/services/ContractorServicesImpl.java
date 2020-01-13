package com.capgemini.forestmanagementrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.dao.ContractorDAO;
import com.capgemini.forestmanagementrest.dto.ContractorBean;

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
