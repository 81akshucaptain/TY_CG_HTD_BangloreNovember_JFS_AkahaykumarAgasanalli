package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.LandsBean;

public class LandsDAOImpl implements LandsDAO {
	private static HashMap<Integer,LandsBean> h1=new HashMap<Integer,LandsBean>();
	int lid=0;

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
		h1.replace(lid,landToUpdate );
		return true;
	}

	@Override
	public boolean deleteLands(int cid) {
		System.out.println("The specified Land got delated");
		h1.remove(cid);
		return true;
	}

	@Override
	public boolean addLands(LandsBean Land) {
		while(true) {
			//In-order to add generated CUSTOMER-ID to each and
			//every objects
			++lid;
			Land.setLandId(lid);
			h1.put(lid,Land);
			System.out.println("Land with LAND-ID is : "+lid+", added successfully. (please remember)");
			return true;
		}	
	}

	@Override
	public LandsBean searchLands(int lid) {
		if(h1.containsKey(lid)==true) {
			return h1.get(lid);
		}else {
			System.err.println("No such land Exist..!");
			return null;
		}	
	}

}
