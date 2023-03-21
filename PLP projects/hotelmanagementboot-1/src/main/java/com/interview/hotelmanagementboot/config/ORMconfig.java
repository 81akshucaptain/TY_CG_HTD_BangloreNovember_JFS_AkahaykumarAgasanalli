package com.interview.hotelmanagementboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
//Tags the class as a source of bean definitions for the application context.
//Spring Configuration annotation indicates that the class has @Bean definition methods. 
//So Spring container can process the class and generate Spring Beans to be used in the application.
public class ORMconfig {
	/*
	 * A bean is an object that is instantiated, assembled, and otherwise managed by
	 * a Spring IoC container. Otherwise, a bean is simply one of many objects in
	 * your application
	 */
	/*
	 * What is JPA? Java Persistence API is a collection of classes and methods to
	 * persistently store the vast amounts of data into a database which is provided
	 * by the Oracle Corporation.
	 */

	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
		// The LocalEntityManagerFactoryBean creates an EntityManagerFactory suitable
		// for
		// environments which solely use JPA for data access.
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		// Specify the name of the EntityManagerFactory configuration.
		bean.setPersistenceUnitName("newhotel_unit");
		return bean;
		
		/*
		 * The persistence.xml configuration file is used to configure a given JPA
		 * Persistence Unit. The Persistence Unit defines all the metadata required to
		 * bootstrap an EntityManagerFactory, like entity mappings, data source, and
		 * transaction settings, as well as JPA provider configuration properties.
		 */

	}
}
