package com.cagnosolutions.cei.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
				"SELECT username, password, enabled FROM users WHERE username=?")
				.authoritiesByUsernameQuery(
						"SELECT username, role FROM user_roles WHERE username=?");
	}	

	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/static/**", "/index").permitAll() .anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/auth")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/index?logout")
				.permitAll()
				.and()
			.exceptionHandling().accessDeniedPage("/403")
				.and()
			.csrf();
	}
}
