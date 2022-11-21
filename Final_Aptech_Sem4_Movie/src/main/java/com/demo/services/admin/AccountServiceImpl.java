package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.repositories.admin.AccountRepository;





@Service("AdminAccountImplService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public boolean create(Account a) {
		try {
			accountRepository.save(a);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Page<Account> findAll(int numberPage) {
		Pageable pageable = PageRequest.of(numberPage - 1 , 20);
		return accountRepository.findAllByStatus(pageable);
	}

	@Override
	public Account findById(int id) {
		return accountRepository.findAccountById(id);
	}

	@Override
	public void delete(Account account) {
		accountRepository.delete(account);
	}

	@Override
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	


}
