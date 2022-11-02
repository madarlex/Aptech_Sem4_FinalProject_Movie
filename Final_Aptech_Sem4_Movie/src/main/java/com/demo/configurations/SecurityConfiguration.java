package com.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.services.AccountService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private AccountService accountService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//cors, csrf
		http.cors().and().csrf().disable();
		http.authorizeHttpRequests()
			.antMatchers("/home/**", "/aboutus/**").permitAll()
//			.antMatchers("/desk/**").hasAuthority("ROLE_SUPER_ADMIN")
			.antMatchers("/movie/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
			.antMatchers("/ticket/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
			.antMatchers("/account/history").hasAnyAuthority("ROLE_USER")
			.antMatchers("/account/edit").hasAnyAuthority("ROLE_USER")
			.antMatchers("/about/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
			.and()
			.formLogin().loginPage("/account/login")
			.loginProcessingUrl("/account/processLogin") // khai bao trong login.jsp
			.usernameParameter("username") //name cua input username
			.passwordParameter("password") //name cua input password
			.defaultSuccessUrl("/home") // login successfull go to welcome
			.failureUrl("/account/login?error")
			.and()
			.logout().logoutUrl("/account/logout")
			.logoutSuccessUrl("/account/login")
			.and()
			.exceptionHandling().accessDeniedPage("/error/404")
			;
		return http.build();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(accountService);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
