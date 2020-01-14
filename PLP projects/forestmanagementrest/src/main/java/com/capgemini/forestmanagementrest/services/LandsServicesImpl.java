package com.capgemini.forestmanagementrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementrest.dao.LandsDAO;
import com.capgemini.forestmanagementrest.dto.LandsBean;
import com.capgemini.forestmanagementrest.exceptions.VallidationExceptionFMS;
import com.capgemini.forestmanagementrest.util.Validations;

@Service
public class LandsServicesImpl implements LandsServices {

	@Autowired
	LandsDAO landsDao;

	@Override
	public List<LandsBean> getAllLands() {
		return landsDao.getAllLands();
	}

	@Override
	public boolean updateLands(int lid, LandsBean landToUpdate) {
		try {
			if (Validations.numberValidation(landToUpdate.getLandSize())
					&& Validations.alphabetsValidation(landToUpdate.getLandLocation())
					&& Validations.alphabetsValidation(landToUpdate.getLandResources())) {
				return landsDao.updateLands(lid, landToUpdate);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteLands(int lid) {
		try {
			if (Validations.numberValidation(lid)) {
				return landsDao.deleteLands(lid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public LandsBean searchLands(int cid) {
		try {
			if (Validations.numberValidation(cid)) {
				return landsDao.searchLands(cid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public boolean addLands(LandsBean Land) {
		try {
			if (Validations.numberValidation(Land.getLandId()) 
					&& Validations.numberValidation(Land.getLandSize())
					&& Validations.alphabetsValidation(Land.getLandLocation())
					&& Validations.alphabetsValidation(Land.getLandResources())) {
				return landsDao.addLands(Land);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;

	}

}
