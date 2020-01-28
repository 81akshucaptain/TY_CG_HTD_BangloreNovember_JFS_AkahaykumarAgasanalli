package com.capgemini.forestmnagementdb.dao;

import java.util.List;

import com.capgemini.forestmnagementdb.bean.LandsBean;

public interface LandsDAO {
	public List<LandsBean> getAllLands();
	public boolean updateLands(int cid,LandsBean landToUpdate);
	public boolean deleteLands(int cid);
	//create LandsBean obje and pass to insert all values
	public boolean addLands(LandsBean Land);
	public LandsBean searchLands(int cid);

}
