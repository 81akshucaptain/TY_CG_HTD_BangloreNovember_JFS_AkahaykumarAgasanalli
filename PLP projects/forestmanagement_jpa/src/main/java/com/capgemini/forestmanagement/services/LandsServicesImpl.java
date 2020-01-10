package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dao.LandsDAO;
import com.capgemini.forestmanagementjpa.dto.LandsBean;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class LandsServicesImpl  implements LandsServices{

	LandsDAO landsDao=ForestFactoryFmJpa.createInstanceOfLandsDAOImpl();

	@Override
	public void getAllLands() {
		// TODO Auto-generated method stub
		landsDao.getAllLands();
	}

	@Override
	public boolean updateLands(int cid, LandsBean landToUpdate) {
		// TODO Auto-generated method stub
		return landsDao.updateLands(cid, landToUpdate);
	}

	@Override
	public boolean deleteLands(int cid) {
		// TODO Auto-generated method stub
		return landsDao.deleteLands(cid);
	}


	@Override
	public LandsBean searchLands(int cid) {
		// TODO Auto-generated method stub
		return landsDao.searchLands(cid);
	}

	@Override
	public boolean addLands(LandsBean Land) {
		// TODO Auto-generated method stub
		return false;
	}

		
}
