package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.foresterymanagement.bean.LandsBean;
import com.capgemini.foresterymanagement.dao.LandsDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class LandsDAOImplTest {

	LandsDAO landDAO =ForestFactory.InstanceOfLandDAOImpl();
	LandsBean land = new LandsBean();
	
	@Test
	void testAddLand() {
		LandsBean land = new LandsBean();
		land.setLandSize("877");
		land.setLandResources("WOODS");
		try {
			boolean flag = landDAO.addLands(land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				landDAO.addLands(land);
			});
		}
	}

	@Test
	void testDeleteLand() {
		try {
			boolean flag = landDAO.deleteLands(land.getLandId());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				landDAO.deleteLands(444);
			});
		}
	}


	@Test
	void testUpdateLand() {
		LandsBean land = new LandsBean();
		land.setLandId(land.getLandId());
		land.setLandResources("BATTI");
		land.setLandSize("522");
		try {
			boolean flag = landDAO.updateLands(land.getLandId(), land);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				landDAO.updateLands(land.getLandId(), land);
			});
		}
	}

	
	@Test
	void testSearchForFalse() {
		int landNo = 108;
		try {
			LandsBean bean= landDAO.searchLands(landNo);
			assertEquals(bean!=null, false);
		}catch(Exception e) {
			assertThrows(Exception.class,()->{
				landDAO.searchLands(landNo);
			});
		}
		
	}
	@Test
	void testDisplayLand() {
		HashMap<Integer, LandsBean> list =  landDAO.getAllLands();
		assertNotNull(list);
	}
	/*@Test
	void testSearchForTrue() {
		int landNo = land.getLandId();
		try {
			LandsBean bean= landDAO.searchLands(landNo);
			assertEquals(bean!=null, true);
		}catch(Exception e) {
			assertThrows(Exception.class,()->{
				landDAO.searchLands(landNo);
			});
		}*/
		
	}

	

