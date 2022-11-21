package com.demo.services.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Usertype;
import com.demo.repositories.admin.UserTypeRepository;





@Service("AdminUserTypeService")
public class UserTypeServiceImpl implements UserTypeService {
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	@Override
	public Iterable<Usertype> findAll() {
		return userTypeRepository.findAll();
	}
	


}
