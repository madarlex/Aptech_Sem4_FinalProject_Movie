package com.demo.services.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.models.Account;



@Service("AdminAccountService")
public interface AccountService {

	public boolean create(Account a);
	
	public Account findById(int id);
	
	public void delete(Account account);
	
	public Page<Account> findAll(int numberPage);
	
	public Iterable<Account> findAll();
}
