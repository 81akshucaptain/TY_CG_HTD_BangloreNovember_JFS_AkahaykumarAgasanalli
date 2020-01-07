package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.LandsBean;
import com.capgemini.foresterymanagement.exception.LandsAppException;

public class LandsDAOImpl implements LandsDAO {
	private static HashMap<Integer,LandsBean> h1=new HashMap<Integer,LandsBean>();
	static int lid=0;

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
	public boolean updateLands(int lid, LandsBean landToUpdate) {
		if(h1.replace(lid,landToUpdate )!=null) {
			return true;
		}else {
			throw new LandsAppException("Lnad Id not Found, Please Try Again");
		}
	}

	@Override
	public boolean deleteLands(int cid) {
		if(h1.remove(cid)!=null) {
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
			++lid;
			Land.setLandId(lid);
			try{
				h1.put(lid,Land);
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
