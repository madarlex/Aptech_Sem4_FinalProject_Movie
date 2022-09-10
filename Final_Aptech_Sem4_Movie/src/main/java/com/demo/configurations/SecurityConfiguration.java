package com.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfiguration {
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// cors, csrf
		http.cors().and().csrf().disable();
		
		http.authorizeRequests().antMatchers("/admin**").access("hasRole('admin')")
		.antMatchers("/accounts/**").permitAll()
		.and()
		.formLogin().loginPage("/account/login")
		.loginProcessingUrl("/account/processLogin")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/account/welcome")
		.failureUrl("/account/login?error")
		.and()
		.logout().logoutUrl("/account/logout")
		.logoutSuccessUrl("/account/login")
		.and()
		.exceptionHandling().accessDeniedPage("/account/accessDenied");
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(accountService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
