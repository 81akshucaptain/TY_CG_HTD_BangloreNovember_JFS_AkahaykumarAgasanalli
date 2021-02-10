package com.tcs.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*     THREE TYPES OF CONFIGURATIONS IN SPRINGS
1.ApplicationContext.xml
2.Using Component Scan in XML file and using annotations
3.Using Java CONFIG CLASS and using @Configuration Annotation 
                   NOOOOO XML 
*/
//@Component is Different @ComponentScan is different
//@Component registers automatically instead @Bean Explicitly register
/*
 * @ComponentScan("com.tcs.springdemo")
 *@PropertySource("classpath:sports.properties")
 */

@Configuration
public class SportsConfigurationClass {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
