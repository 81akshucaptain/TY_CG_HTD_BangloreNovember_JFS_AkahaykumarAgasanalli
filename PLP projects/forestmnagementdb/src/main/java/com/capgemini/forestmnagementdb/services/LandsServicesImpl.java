package com.capgemini.forestmnagementdb.services;

import com.capgemini.forestmnagementdb.bean.LandsBean;
import com.capgemini.forestmnagementdb.dao.LandsDAO;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;

public class LandsServicesImpl  implements LandsServices{

	LandsDAO landsDao=ForestFactoryJdbc.createInstanceOfLandsDAOImpl();

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
	public boolean addLands(LandsBean Land) {
		// TODO Auto-generated method stub
		return landsDao.addLands(Land);
	}

	@Override
	public LandsBean searchLands(int cid) {
		// TODO Auto-generated method stub
		return landsDao.searchLands(cid);
	}

	
}
