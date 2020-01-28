package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.LandsBean;
import com.capgemini.foresterymanagement.dao.LandsDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class LandsServicesImpl  implements LandsServices{

	LandsDAO landsDao=ForestFactory.InstanceOfLandDAOImpl();

	@Override
	public void getAllLands() {
		landsDao.getAllLands();		
	}

	@Override
	public boolean updateLands(int cid, LandsBean landToUpdate) {
		return landsDao.updateLands(cid, landToUpdate);
	}

	@Override
	public boolean deleteLands(int cid) {
		return landsDao.deleteLands(cid);
	}

	@Override
	public boolean addLands(LandsBean Land) {
		return landsDao.addLands(Land);
	}

	@Override
	public LandsBean searchLands(int cid) {
		return landsDao.searchLands(cid);
	}

}
