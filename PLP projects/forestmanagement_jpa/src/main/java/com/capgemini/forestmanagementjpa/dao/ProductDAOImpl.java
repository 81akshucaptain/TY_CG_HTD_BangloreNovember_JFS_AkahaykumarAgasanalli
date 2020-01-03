package com.capgemini.forestmanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementjpa.dto.CustomerBean;
import com.capgemini.forestmanagementjpa.dto.ProductBean;

public class ProductDAOImpl implements ProductDAO {
	EntityManagerFactory eFactory=null;
	EntityTransaction etTransaction=null;
	@Override
	public void getAllProduct() {
		try{
			String jpql="from ProductBean";
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<ProductBean> records=query.getResultList();
			for (ProductBean productBean : records) {
				System.out.println("PRODUCT-ID      ="+productBean.getPID());
				System.out.println("PRODUCT-NAME    ="+productBean.getName());
				System.out.println("PRODUCT-QUANTITY="+productBean.getQantity());
				System.out.println("PRODUCT-CLASS   ="+productBean.getProductClass());
				System.out.println("PRODUCT-COST    ="+productBean.getCost());
				System.out.println("===============================================");
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("No data for Products,try again..!");
		}
	}
	@Override
	public boolean updateProduct(ProductBean ProductToUpdate) {
		try{

			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ProductBean set name=:name,productClass=:pclass,"
					+ "quantity=:quantity,cost=:cost where PID=:pid";
			Query query=emManager.createQuery(jpql);
			query.setParameter("name",ProductToUpdate.getName());
			query.setParameter("pclass",ProductToUpdate.getProductClass());
			query.setParameter("quantity", ProductToUpdate.getQantity());
			query.setParameter("cost", ProductToUpdate.getCost());
			query.setParameter("pid", ProductToUpdate.getPID());
			int result=query.executeUpdate();
			etTransaction.commit();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in updating the product, try again"+message);
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int pid) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			ProductBean cbBean=emManager.find(ProductBean.class, pid);
			emManager.remove(cbBean);
			etTransaction.commit();
			return true;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Failed to Find product, try again: "+message);
			return false;
		}
	}
	@Override
	public boolean addProduct(ProductBean product) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			emManager.persist(product);
			etTransaction.commit();
			return true;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Failed to add product,Product may already exist, try again: "+message);
			return false;
		}
	}

	@Override
	public ProductBean searchProduct(int pid) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			ProductBean productBean=emManager.find(ProductBean.class, pid);
			//			System.out.println("PRODUCT-ID="+productBean.getPID());
			//			System.out.println("PRODUCT-NAME="+productBean.getName());
			//			System.out.println("PRODUCT-QUANTITY="+productBean.getQantity());
			//			System.out.println("PRODUCT-CLASS="+productBean.getProductClass());
			//			System.out.println("PRODUCT-COST="+productBean.getCost());
			etTransaction.commit();
			if(productBean!=null) {
				return productBean;
			}else {
				System.out.println("Product Not found..!");
				return null;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Problem in finding the productId, Data not found, Try again"+message);
			return null;
		}
	}

	@Override
	public boolean checkIsTherePID(int pid) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			ProductBean productBean=emManager.find(ProductBean.class, pid);
			etTransaction.commit();
			if(productBean.getPID()==pid) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Problem In Finding The productId In Inventory Try Again:"+message);
			return false;
		}


	}

}
