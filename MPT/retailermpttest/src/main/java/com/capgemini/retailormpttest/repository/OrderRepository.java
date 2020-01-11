package com.capgemini.retailormpttest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.retailormpttest.dto.OrderInfoBean;

public interface OrderRepository extends JpaRepository<OrderInfoBean, Integer>{
	@Query("from EmployeeBean where name=:key or email=:key")
	public List<OrderInfoBean> findById(@Param("key")int key);

}
