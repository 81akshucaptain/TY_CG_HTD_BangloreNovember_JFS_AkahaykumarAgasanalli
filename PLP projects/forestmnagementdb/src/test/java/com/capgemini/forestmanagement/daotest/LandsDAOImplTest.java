package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmnagementdb.bean.LandsBean;
import com.capgemini.forestmnagementdb.bean.ProductBean;
import com.capgemini.forestmnagementdb.dao.CustomerDAOImpl;
import com.capgemini.forestmnagementdb.dao.LandsDAO;
import com.capgemini.forestmnagementdb.dao.LandsDAOImpl;
import com.capgemini.forestmnagementdb.dao.ProductDAO;

public class LandsDAOImplTest {

	LandsDAO landDAO = null;
	LandsBean land = new LandsBean();

	@BeforeEach
	void testCustomerDAOImpl() {
		FileReader reader;
		Properties prop;
		try {
			reader = new FileReader("lands.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("DriverClass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		landDAO = new LandsDAOImpl();
	}

	@Test
	void testAddLand() {
		LandsBean land = new LandsBean();
		land.setLandSize("877");
		land.setLandResources("Tobaco");
		land.setLandId(444);
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
				landDAO.addLands(land);
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
		int landNo = 114;
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
