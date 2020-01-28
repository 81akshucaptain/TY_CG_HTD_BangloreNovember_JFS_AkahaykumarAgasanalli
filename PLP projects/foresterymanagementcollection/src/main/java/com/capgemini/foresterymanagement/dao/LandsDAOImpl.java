package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.LandsBean;
import com.capgemini.foresterymanagement.exception.LandsAppException;

public class LandsDAOImpl implements LandsDAO {
	private static HashMap<Integer,LandsBean> h1=new HashMap<Integer,LandsBean>();
	static int landId=0;

	@Override
	public HashMap<Integer, LandsBean> getAllLands() {
		if(h1.isEmpty()==false) {
			return h1;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean updateLands(int landId, LandsBean landToUpdate) {
		if(h1.replace(landId,landToUpdate )!=null) {
			return true;
		}else {
			throw new LandsAppException("LnadId not Found, Please Try Again");
		}
	}

	@Override
	public boolean deleteLands(int landId) {
		if(h1.remove(landId)!=null) {
			return true;
		}else {
			throw new LandsAppException("Land Id Not Found, Please Try Again");
		}
	}

	@Override
	public boolean addLands(LandsBean Land) {
		while(true) {
			//In-order to add generated CUSTOMER-ID to each and
			//every objects
			++landId;
			Land.setLandId(landId);
			try{
				h1.put(landId,Land);
				return true;
			}catch (Exception e) {
				throw new LandsAppException("Land ID May Exist, Please Try Again");
			}
		}	
	}

	@Override
	public LandsBean searchLands(int lid) {
		if(h1.containsKey(lid)==true) {
			return h1.get(lid);
		}else {
			return null;
		}	
	}

}
