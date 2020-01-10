package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dto.LandsBean;

public interface LandsServices {
	public void getAllLands();
	public boolean updateLands(int cid,LandsBean landToUpdate);
	public boolean deleteLands(int cid);
	//create LandsBean obje and pass to insert all values
	public boolean addLands(LandsBean Land);
	public LandsBean searchLands(int cid);

}
