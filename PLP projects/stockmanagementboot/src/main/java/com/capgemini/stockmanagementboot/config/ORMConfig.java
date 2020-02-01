package com.capgemini.stockmanagementboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

//@Configuration --It help's spring container to generate bean definitions 
//and services Requests for beans at runtime
//public class ORMConfig {
//	
//	@Bean
//	public LocalEntityManagerFactoryBean getlocalEntityManagerFactoryBean() {
//		// LocalEntityManagerFactoryBean --can be used to register JPA 
//		// EntityMangerFactory as a bean, This is the standard way of loading JPA Factory
//		LocalEntityManagerFactoryBean registerJpaAsBean = new LocalEntityManagerFactoryBean();
//		registerJpaAsBean.setPersistenceUnitName("stock_unit");
//		return registerJpaAsBean;
//	}
//}
@Configuration
public class ORMConfig {

	@Bean
	public LocalEntityManagerFactoryBean getLocalEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean bean=new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("stock_unit");
		return bean;
	}
}
