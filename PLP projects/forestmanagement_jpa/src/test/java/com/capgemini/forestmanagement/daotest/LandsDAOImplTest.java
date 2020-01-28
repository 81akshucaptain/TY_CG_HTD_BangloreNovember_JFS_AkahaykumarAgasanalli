package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementjpa.dao.LandsDAO;
import com.capgemini.forestmanagementjpa.dao.LandsDAOImpl;
import com.capgemini.forestmanagementjpa.dto.LandsBean;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class LandsDAOImplTest {

	LandsDAO landDAO =ForestFactoryFmJpa.createInstanceOfLandsDAOImpl();
	LandsBean land = new LandsBean();

	@Test
	void testAddLand() {
		LandsBean land = new LandsBean();
		land.setLandSize("877");
		land.setLandResources("WOODS");
		land.setLandLocation("Dharwad");
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
			boolean flag = landDAO.deleteLands(444);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				landDAO.deleteLands(444);
			});
		}
	}

	@Test
	void testDisplayLand() {
		List<LandsBean> list = landDAO.getAllLands();
		assertNotNull(list);
	}

	@Test
	void testUpdateLand() {
		LandsBean land = new LandsBean();
		land.setLandId(444);
		land.setLandResources("BATTI");
		land.setLandSize("522");
		land.setLandLocation("HUliDurga");
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
	void testSearchForTrue() {
		int landNo = 50;
		try {
			LandsBean bean= landDAO.searchLands(landNo);
			assertEquals(bean!=null, true);
		}catch(Exception e) {
			assertThrows(Exception.class,()->{
				landDAO.searchLands(landNo);
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

}
