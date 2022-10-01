package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.Movie;
import com.demo.models.Usertype;




public interface AccountService extends UserDetailsService {
	public Account save(Account account);	
	public Account findByUsername(String username); 
}
