package com.capgemini.forestmanagementrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.dao.LandsDAO;
import com.capgemini.forestmanagementrest.dto.LandsBean;

@Service
public class LandsServicesImpl  implements LandsServices{

	@Autowired
	LandsDAO landsDao;
	@Override
	public List<LandsBean> getAllLands() {
		return landsDao.getAllLands();
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
		return landsDao.addLands(Land);
	}

		
}
