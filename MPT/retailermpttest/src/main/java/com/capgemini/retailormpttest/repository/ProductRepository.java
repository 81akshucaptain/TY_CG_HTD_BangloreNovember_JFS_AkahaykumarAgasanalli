package com.capgemini.retailormpttest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.retailormpttest.dto.ProductInfoBean;

public interface ProductRepository extends JpaRepository<ProductInfoBean, Integer> {
	
	@Query("from EmployeeBean where name=:key or email=:key")
	public List<ProductInfoBean> findById(@Param("key")int productId);
	

}
