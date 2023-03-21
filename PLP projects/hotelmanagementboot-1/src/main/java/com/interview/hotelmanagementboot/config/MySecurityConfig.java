package com.interview.hotelmanagementboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import com.interview.hotelmanagementboot.dao.CustomerDaoIMPL;
import com.interview.hotelmanagementboot.service.CustomeUserDetails;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userD;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

		// Using basic HTTP Authentication
		// BASIC AUTH using system generated pswd
		// http.csrf().disable();// TO TEST IN POST MAN an all
		// http.authorizeRequests().anyRequest().authenticated().and().httpBasic();

		// Using ANT matchers
		// we can also mention which HTTP method should be it be in ant-matchers
		// http.authorizeRequests().antMatchers("/public/**").permitAll()
		// .anyRequest().authenticated().and().httpBasic();

		// ROLE BASED AUTHENTICATION //both can be accessed by ones

		http.authorizeRequests().antMatchers("/public/**").hasRole("NORMAL").antMatchers("/customer/**")
				.hasRole("ADMIN").antMatchers("/signin").permitAll() //
				.antMatchers("/public/**").hasRole("ADMIN").anyRequest().authenticated().and() // .httpBasic();//HTTP
				.formLogin();

		// FORM BASED AUTHENTICATION
		// .loginProcessingUrl("doLogin")//doLogin is HTML form action name
		// .defaultSuccessUrl("/customer/get.all.customer");

		// LEARN ABOUT CSRF -cross site request forgery-its attack so spring security
		// save us from this
		// if we try to post an Put data request suddenly it wont work, so no browser
		// client ex: post man and
		// all u need to disable it
		// http.csrf().disable();
		// or in-order to customise and check the actually correct flow
		// http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		// and take this token from header and plcae it in request it will work--BY
		// DURGESH SIR-SPRING security in one video 01:46 minutes

	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { // TODO Auto-generated method stub // Without DB data, using
	 * inmemory concept /*
	 * auth.inMemoryAuthentication().withUser("akshay").password(this.
	 * passwordEncoder().encode("abc")).roles("NORMAL");
	 * auth.inMemoryAuthentication().withUser("abhi").password(this.passwordEncoder(
	 * ).encode("123")).roles("ADMIN");
	 */
	// }

	// USING DB
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userD).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// return NoOpPasswordEncoder.getInstance(); // When there is Encoder
		return new BCryptPasswordEncoder(10);
	}

}
