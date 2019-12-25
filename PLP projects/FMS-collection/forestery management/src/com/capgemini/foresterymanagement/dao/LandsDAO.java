package com.capgemini.foresterymanagement.dao;

import com.capgemini.foresterymanagement.bean.LandsBean;

public interface LandsDAO {
	public void getAllLands();
	public boolean updateLands(int cid,LandsBean landToUpdate);
	public boolean deleteLands(int cid);
	//create LandsBean obje and pass to insert all values
	public boolean addLands(LandsBean Land);
	public LandsBean searchLands(int cid);
}
